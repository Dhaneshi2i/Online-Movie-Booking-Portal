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

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showrepository;

    private final TheatreService theatreService;

    private final ScreenService screenService;
    private final MovieService movieService;
    private final MapStructMapper mapper;

    public ShowServiceImpl(ShowRepository showrepository, TheatreService theatreService, ScreenService screenService,
                           MovieService movieService, MapStructMapper mapper) {
        this.showrepository = showrepository;
        this.theatreService = theatreService;
        this.screenService = screenService;
        this.movieService = movieService;
        this.mapper = mapper;
    }


    @Override
    public ShowSlimDto createShow(ShowDto showDto, int theatreId, int screenId, int movieId)  {
        showDto.setScreen(screenService.getScreenById(screenId));
        showDto.setTheatre(theatreService.findTheatreById(theatreId));
        showDto.setMovie(movieService.getMovieById(movieId));
        System.out.println(movieService.getMovieById(movieId).getMovieName());
        //System.out.println(showDto.getMovie().getMovieId());
        //System.out.println(movieService.getMovieById(showDto.getMovie().getMovieId()));
        //showDto.setMovie(mapper.movieDtoToMovieSlimDto(movieService.getMovieById(showDto.getMovie().getMovieId())));
        return mapper.showToShowSlimDto(showrepository.save(mapper.showDtoToShow(showDto)));
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

//    @Override
//    public List<ShowDto> getShowByDate(LocalDate date) {
//        List<Show> shows = new ArrayList<>();
//        for (Show show : showrepository.findAll()) {
//            if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
//                shows.add(show);
//            }
//        }
//        return showsDto;
//    }

}

