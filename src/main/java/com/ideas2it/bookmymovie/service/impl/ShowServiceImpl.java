package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowSlimDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.repository.ShowRepository;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.ShowService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private ShowRepository showrepository;
    private TheatreService theatreService;
    private ScreenService screenService;
    private MovieService movieService;
    private MapStructMapper mapper;

    public ShowServiceImpl(ShowRepository showrepository, TheatreService theatreService, ScreenService screenService,
                           MovieService movieService, MapStructMapper mapper) {
        this.showrepository = showrepository;
        this.theatreService = theatreService;
        this.screenService = screenService;
        this.movieService = movieService;
        this.mapper = mapper;
    }


    @Override
    public ShowDto createShow(ShowDto showDto, int theatreId, int screenId, int movieId) {
        showDto.setScreen(screenService.getScreenById(screenId));
        showDto.setTheatre(theatreService.findTheatreById(theatreId));
        showDto.setMovie(movieService.getMovieById(movieId));
        return mapper.showToShowDto(showrepository.save(mapper.showDtoToShow(showDto)));
    }

    @Override
    public ShowDto updateShow(ShowDto showDto, Integer theatreId, Integer screenId) {

        if (theatreId != null) {
            showDto.setTheatre(theatreService.findTheatreById(theatreId));
        }
        if (screenId != null) {
            showDto.setScreen(screenService.getScreenById(screenId));
        }

        Show show = mapper.showDtoToShow(showDto);
        showDto = mapper.showToShowDto(showrepository.saveAndFlush(show));
        return showDto;
    }

    @Override
    public void removeShow(int showId) {
        Show show = showrepository.findById(showId).get();

        show.setStatus(true);

    }

    @Override
    public ShowDto getShowById(int showId) {
        return mapper.showToShowDto(showrepository.findById(showId).get());
    }

    @Override
    public List<ShowDto> getAllShow() {
        return mapper.showListToShowSlimDtoList(showrepository.findAll());
    }

    @Override
    public List<ShowDto> getShowByTheatreId(int theatreid) {
        return mapper.showListToShowDtoList(showrepository.getAllByTheatreId(theatreid));

    }

    @Override
    public List<ShowDto> getShowsByDate(LocalDate date) {
        List<Show> shows = new ArrayList<>();
        for (Show show : showrepository.findAll()) {
            if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
                shows.add(show);
            }
        }
        return mapper.showListToShowDtoList(shows);
    }
}

