package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.TimeSlotDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowResponseDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.ShowRepository;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.ShowService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showrepository;
    private final ScreenService screenService;
    private final MovieService movieService;
    private final SeatService seatService;
    private final TheatreService theatreService;
    private final MapStructMapper mapper;

    public ShowServiceImpl(ShowRepository showrepository, ScreenService screenService,
                           MovieService movieService, SeatService seatService, TheatreService theatreService, MapStructMapper mapper ) {

        this.showrepository = showrepository;
        this.screenService = screenService;
        this.movieService = movieService;
        this.seatService = seatService;
        this.theatreService = theatreService;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create Show Details
     * </p>
     *
     * @param showDto it contains show dto objects
     * @return ShowDto
     */
    @Override
    @Transactional
    public List<ShowResponseDto> createShow(ShowDto showDto){
        List<Show> shows = new ArrayList<>();
        Screen screen = mapper.screenDtoToScreen(screenService.getScreenById(showDto.getScreen().getId()));
        for (TimeSlotDto timeSlot : showDto.getTimeSlots()) {
            Show show = new Show();
            show.setShowStartTime(timeSlot.getShowStartTime());
            show.setShowDate(showDto.getShowDate());
            show.setScreen(screen);
            show.setMovie(mapper.movieDtoToMovie(movieService.getMovieById(showDto.getMovie().getId())));
            showrepository.save(show);
            createSeat(show);
            shows.add(show);
        }
        Theatre theatre = mapper.theatreDtoToTheatre(theatreService.findTheatreById(screen.getTheatre().getTheatreId()));
        if (shows.isEmpty()) {
            throw new NotFoundException("No shows found ");
        }
        for (Show show : shows) {
            theatre.getShows().add(show);
        }
        //theatre.setShows(shows);
        theatreService.updateTheatre(mapper.theatreToTheatreDto(theatre));
        return mapper.showListToShowResponseDtoList(shows);
    }

    private void createSeat(Show show) {

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
                'v','w','x','y','z'};
        for (SeatType seatType : show.getScreen().getSeatTypes()) {
            int row = seatType.getNoOfRows();
            int column = seatType.getNoOfColumns();
            for (int i = 0; i < row; i++) {
                for (int j = 1; j <= column; j++) {
                    Seat seat = new Seat();
                    seat.setSeatType(seatType);
                    seat.setSeatPrice(seatType.getPrice());
                    seat.setSeatNumber(alphabet[i] + "" + j);
                    seat.setSeatStatus(SeatStatus.AVAILABLE);
                    seat.setShow(show);
                    seat.setShowDate(show.getShowDate());
                    seatService.createSeat(seat);
                }
            }
        }
    }

    /**
     * <p>
     * This method updates Show Details
     * </p>
     *
     * @param showDto it contains show dto objects
     * @return ShowDto
     */
    @Override
    public ShowDto updateShow(ShowDto showDto) {
        Show show = showrepository.findByShowId(showDto.getId());
        if (null == show) {
            throw new NotFoundException("No show were found for this id");
        }
        show.setStatus(true);
        return mapper.showToShowDto(showrepository.save(show));
    }

    /**
     * <p>
     * This method gets the Show Details with given id
     * </p>
     *
     * @param showId it contains show id
     * @return ShowDto
     */
    @Override
    public ShowResponseDto getShowById(int showId) {
        Show show = showrepository.findByShowId(showId);
        if (null == show) {
            throw new NotFoundException("No shows were found for respective id " + showId);
        } else {
            return mapper.showToShowResponseDto(show);
        }
    }

    /**
     * <p>
     * This method List all the Show Details
     * </p>
     *
     * @return List<ShowDto>
     */
    @Override
    public List<ShowResponseDto> getAllShow(int pageNumber, int pageSize) {
        List<Show> shows = showrepository.findAll();
        if (shows.isEmpty()) {
            throw new NotFoundException("No shows available");
        } else {

            Pageable p = PageRequest.of(pageNumber, pageSize);
            Page<Show> show = showrepository.findAll(p);
            return mapper.showListToShowResponseDtoList(show.getContent());

        }
    }

    /**
     * <p>
     * This method List all the Screen Details by Theatre
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return List<ShowResponseDto>
     */
    /*@Override
    public List<ShowResponseDto> getShowByTheatreId(int theatreId) {
        List<Show> shows = showrepository.getAllByTheatreId(theatreId);
        if (shows.isEmpty()) {
            throw new NotFoundException("No shows available for respective theatre " + theatreId);
        }
        return mapper.showListToShowResponseDtoList(shows);
    }*/

    /**
     * <p>
     * This method List all the Screen Details by Date
     * </p>
     *
     * @param date it contains date
     * @return List<ShowResponseDto>
     */
    @Override
    public List<ShowResponseDto> getShowsByDate(LocalDate date) {
        List<Show> shows = new ArrayList<>();
        for (Show show : showrepository.findAll()) {
            if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
                shows.add(show);
            }
        }
        if(shows.isEmpty()) {
            throw new NotFoundException("No shows available for respective date " + date);
        } else {
            return mapper.showListToShowResponseDtoList(shows);
        }
    }
}

