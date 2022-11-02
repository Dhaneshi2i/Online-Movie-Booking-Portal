package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowResponseDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.model.TimeSlot;
import com.ideas2it.bookmymovie.repository.ShowRepository;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.ShowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showrepository;
    private final ScreenService screenService;
    private final MovieService movieService;
    private final SeatService seatService;
    private final MapStructMapper mapper;

    public ShowServiceImpl(ShowRepository showrepository,ScreenService screenService,
                           MovieService movieService, SeatService seatService, MapStructMapper mapper ) {

        this.showrepository = showrepository;
        this.screenService = screenService;
        this.movieService = movieService;
        this.seatService = seatService;
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
        List<TimeSlot> timeslots = screen.getTimeSlots();
        for (TimeSlot timeSlot : timeslots) {
            Show show = new Show();
            show.setShowDate(showDto.getShowDate());
            show.setShowStartTime(timeSlot.getShowStartTime());
            show.setScreen(screen);
            show.setTheatre(screen.getTheatre());
            show.setMovie(mapper.movieDtoToMovie(movieService.getMovieById(showDto.getMovie().getId())));
            showrepository.save(show);
            createSeat(show);
            shows.add(show);
        }
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
     * @param showId  it contains screen id
     * @return ShowDto
     */
    @Override
    public List<ShowDto> updateShow(ShowDto showDto, int showId) {
        Optional<Show> show = showrepository.findById(showId);
        if (show.isPresent()) {
            show.get().setStatus(true);
            showrepository.save(show.get());
        }
        return mapper.showListToShowDtoList(showrepository.findAllByStatus(true));
    }


    /**
     * <p>
     * This method deletes the Show Details
     * </p>
     *
     * @param showId it contains show id
     * @return ShowDto
     */
    @Override
    public void removeShow(int showId) {
        Show show = showrepository.findByShowId(showId);
        if (null == show) {
            throw new NotFoundException("No shows found for respective Id " + showId);
        } else {
            show.setStatus(true);
        }
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
    public ShowDto getShowById(int showId) {
        Show show = showrepository.findByShowId(showId);
        if (null == show) {
            throw new NotFoundException("No shows were found for respective id " + showId);
        } else {
            return mapper.showToShowDto(show);
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
    public List<ShowDto> getAllShow() {
        List<Show> shows = showrepository.findAll();
        if (shows.isEmpty()) {
            throw new NotFoundException("No shows available");
        } else {
            return mapper.showListToShowSlimDtoList(shows);
        }
    }

    /**
     * <p>
     * This method List all the Screen Details by Theatre
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return List<ShowDto>
     */
    @Override
    public List<ShowDto> getShowByTheatreId(int theatreId) {
        List<Show> shows = showrepository.getAllByTheatreId(theatreId);
        if (shows.isEmpty()) {
            throw new NotFoundException("No shows available for respective theatre " + theatreId);
        } else {
            return mapper.showListToShowDtoList(shows);
        }
    }

    /**
     * <p>
     * This method List all the Screen Details by Date
     * </p>
     *
     * @param date it contains date
     * @return List<ShowDto>
     */
    @Override
    public List<ShowDto> getShowsByDate(LocalDate date) {
        List<Show> shows = new ArrayList<>();
        for (Show show : showrepository.findAll()) {
            if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
                shows.add(show);
            }
        }
        if(shows.isEmpty()) {
            throw new NotFoundException("No shows available for respective date " + date);
        } else {
            return mapper.showListToShowDtoList(shows);
        }
    }

    /**
     * <p>
     * This method List all the Screen Details by theatreCity
     * </p>
     *
     * @param theatreCity it contains theatreCity
     * @return List<ShowDto>
     */
    @Override
    public List<ShowDto> getShowByTheatreLocation(String theatreCity) {
        List<Show> shows = new ArrayList<>();
        for (Show show : showrepository.findAll()) {
            if (show.getTheatre().getTheatreCity().equalsIgnoreCase(theatreCity)) {
                shows.add(show);
            }
        }
        if (shows.isEmpty()) {
            throw new NotFoundException("No movie shows were found for the given location " + theatreCity);
        } else {
            return mapper.showListToShowDtoList(shows);
        }
    }
}

