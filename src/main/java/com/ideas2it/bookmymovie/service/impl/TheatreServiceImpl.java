package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.TheatreNotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.MovieRepository;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.repository.TheatreRepository;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;

    private final ScreenRepository screenRepository;

    private final MovieRepository movieRepository;

    private final MapStructMapper mapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository, ScreenRepository screenRepository,
                              MovieRepository movieRepository, MapStructMapper mapper) {
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }

    @Override
    public List<TheatreDto> getAllTheatres() throws TheatreNotFoundException {
        List<Theatre> theatres = theatreRepository.findAllByStatus(true);
        if (theatres.isEmpty()) {
            throw new TheatreNotFoundException("No Details Present Here");
        }
        return theatres.stream().
                map(theatre -> mapper.theatreToTheatreDto(theatre)).collect(Collectors.toList());
    }

    @Override
    public TheatreDto findTheatres(int theatreId) {

        if (theatreRepository.existsById(theatreId)) {
            return mapper.theatreToTheatreDto(theatreRepository.findById(theatreId).get());
        } else
            return null;
    }

    @Override
    public TheatreDto addTheatre(TheatreDto theatreDto) throws TheatreNotFoundException {
        return mapper.theatreToTheatreDto(theatreRepository.save(mapper.theatreDtoToTheatre(theatreDto)));
    }

    @Override
    public List<TheatreDto> updateTheatre(int theatreId) {

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

    public  Theatre findTheatreById(int theatreId) {

        return theatreRepository.findById(theatreId).get();
    }

//    @Override
//    public List<TheatreDto> findTheatresByMovie(BigDecimal movieId) throws TheatreNotFoundException {
//        List<Theatre> theatreList = new ArrayList<>();
//        Movie movie = movieRepository.findById(movieId).get();
//        BigDecimal showID = movie.getShow().getShowId();
//        List<Theatre> theatres = theatreRepository.findAll();
//        for (Theatre theatre : theatres) {
//            List<Show> shows = theatre.getShow();
//            for (Show show : shows) {
//                //if (show.getShowId() == showID) {
//                    theatreList.add(theatre);
//                }
//            }
//        }
//        return mapper.theatreListToTheatreDtoList(theatreList);
//    }

}
