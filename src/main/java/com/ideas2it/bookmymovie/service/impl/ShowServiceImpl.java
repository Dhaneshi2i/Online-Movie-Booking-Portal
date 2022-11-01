package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
<<<<<<< HEAD
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.model.Show;
=======
import com.ideas2it.bookmymovie.model.*;
>>>>>>> cbc8368 (code changes)
import com.ideas2it.bookmymovie.repository.ShowRepository;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.SeatTypeService;
import com.ideas2it.bookmymovie.service.ShowService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showrepository;
    private final TheatreService theatreService;
    private final ScreenService screenService;
    private final MovieService movieService;
    private final SeatService seatService;
    private final MapStructMapper mapper;
    private final SeatTypeService seatTypeService;
=======
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {
    private ShowRepository showrepository;
    private ScreenService screenService;
    private MovieService movieService;
    private SeatService seatService;
    private MapStructMapper mapper;
>>>>>>> cbc8368 (code changes)

    public ShowServiceImpl(ShowRepository showrepository,
                           ScreenService screenService, MovieService movieService, SeatService seatService, MapStructMapper mapper) {
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
    public ShowDto createShow(ShowDto showDto) {
        Show show = new Show();
        show.setShowDate(showDto.getShowDate());
        show.setShowStartTime(showDto.getShowStartTime());
        show.setShowEndTime(showDto.getShowEndTime());
        show.setScreen(mapper.screenDtoToScreen(screenService.getScreenById(showDto.getScreen().getScreenId())));
        show.setTheatre(mapper.theatreDtoToTheatre(screenService.getTheatreByScreenId(showDto
                .getTheatre().getTheatreId())));
        show.setMovie(mapper.movieDtoToMovie(movieService.getMovieById(showDto.getMovie().getMovieId())));
        showrepository.save(show);
        createSeat(show);
        return mapper.showToShowDto(show);
    }

    private void createSeat(Show show) {

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'};
        for (SeatType seatType : show.getScreen().getTypesOfSeats()) {
            int row = seatType.getNoOfRows();
            int column = seatType.getNoOfColumns();
            for (int i = 0; i < row; i++) {
                for (int j = 1; j < column; j++) {
                    Seat seat = new Seat();
                    seat.setSeatType(seatType);
                    seat.setSeatPrice(seatType.getPrice());
                    seat.setSeatNumber(alphabet[i] + "" + j);
                    seat.setSeatStatus(SeatStatus.AVAILABLE);
                    seat.setScreen(show.getScreen());
                    seat.setShow(show);
                    seat.setShowDate(show.getShowDate());
                    seat.setShowStartTime(show.getShowStartTime());
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

        show.setStatus(true);

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
        return mapper.showToShowDto(showrepository.findByShowId(showId));
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
        return showrepository.findAllByStatus(false).stream().
                map(mapper::showToShowDto).collect(Collectors.toList());
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
        return mapper.showListToShowDtoList(showrepository.getAllByTheatreId(theatreId));
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
    public List<ShowDto> getShowsByDate(LocalDate date) throws NotFoundException {
        List<Show> shows = new ArrayList<>();
        for (Show show : showrepository.findAll()) {
            if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
                shows.add(show);
            }
        }
        return mapper.showListToShowDtoList(shows);
    }
}

