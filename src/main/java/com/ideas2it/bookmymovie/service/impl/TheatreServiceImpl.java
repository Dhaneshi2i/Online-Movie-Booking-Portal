package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.TheatreRepository;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;

    private final MovieService movieService;

    private final MapStructMapper mapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository,
                              MovieService movieService, MapStructMapper mapper) {
        this.theatreRepository = theatreRepository;
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @Override
    public List<TheatreDto> getAllTheatre() throws NotFoundException {
        List<Theatre> theatres = theatreRepository.findAllByStatus(true);
        if (theatres.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return theatres.stream().
                map(theatre -> mapper.theatreToTheatreDto(theatre)).collect(Collectors.toList());
    }

    @Override
    public TheatreDto findTheatreById(int theatreId) {
        // TODO Auto-generated method stub
        if (theatreRepository.existsById(theatreId)) {
            return mapper.theatreToTheatreDto(theatreRepository.findById(theatreId).get());
        } else
            return null;
    }

    @Override
    public TheatreDto createTheatre(TheatreDto theatreDto) throws NotFoundException {
        return mapper.theatreToTheatreDto(theatreRepository.save(mapper.theatreDtoToTheatre(theatreDto)));
    }

    @Override
    public List<TheatreDto> updateTheatreById(int theatreId) {
        Theatre theatre = theatreRepository.findById(theatreId).get();
        theatre.setStatus(false);
        theatreRepository.saveAndFlush(theatre);
        return mapper.theatreListToTheatreDtoList(theatreRepository.findAllByStatus(true));
    }

    @Override
    public List<TheatreDto> deleteTheatreById(int theatreId) {
        theatreRepository.deleteById(theatreId);
        return mapper.theatreListToTheatreDtoList(theatreRepository.findAll());
    }

    @Override
    public List<TheatreDto> findTheatresByMovie(int movieId) throws NotFoundException {
        List<Theatre> theatreList = new ArrayList<>();
        Movie movie = movieService.viewMovie(movieId);
        int showId = movie.getShow().getShowId();
        List<Theatre> theatres = theatreRepository.findAll();
        for (Theatre theatre : theatres) {
            List<Show> shows = theatre.getShow();
            for (Show show : shows) {
                if (show.getShowId() == showId) {
                    theatreList.add(theatre);
                }
            }
        }
        return mapper.theatreListToTheatreDtoList(theatreList);
    }
}
