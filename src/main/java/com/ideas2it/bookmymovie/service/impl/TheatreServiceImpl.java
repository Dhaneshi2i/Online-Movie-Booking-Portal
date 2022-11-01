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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private TheatreRepository theatreRepository;

    private MovieService movieService;

    private MapStructMapper mapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository,
                              MovieService movieService, MapStructMapper mapper) {
        this.theatreRepository = theatreRepository;
        this.movieService = movieService;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create Theatre Details
     * </p>
     *
     * @param theatreDto it contains theatre dto object
     * @return TheatreDto
     */
    @Override
    public TheatreDto createTheatre(TheatreDto theatreDto) throws NotFoundException {
        return mapper.theatreToTheatreDto(theatreRepository.save(mapper.theatreDtoToTheatre(theatreDto)));
    }

    /**
     * <p>
     * This method List all the Theatre Details
     * </p>
     *
     * @return List<TheatreDto>
     */
    @Override
    public List<TheatreDto> getAllTheatre() throws NotFoundException {
        List<Theatre> theatres = theatreRepository.findAllByStatus(false);
        if (theatres.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return theatres.stream().
                map(mapper::theatreToTheatreDto).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method gets the Theatre Details which matches the id
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return TheatreDto
     */
    @Override
    public TheatreDto findTheatreById(int theatreId) throws NotFoundException{
        if (theatreRepository.existsById(theatreId)) {
            Theatre theatre = theatreRepository.findByTheatreId(theatreId);
                return mapper.theatreToTheatreDto(theatre);
        }
        return mapper.theatreToTheatreDto(theatreRepository.findByTheatreId(theatreId));
//        throw new NotFoundException("Theatre details with the given id is not found");
    }

    /**
     * <p>
     * This method update the Theatre Details
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return List<TheatreDto>
     */
    @Override
    public List<TheatreDto> updateTheatreById(int theatreId) {
        Optional<Theatre> theatre = theatreRepository.findById(theatreId);
        if(theatre.isPresent()) {
            theatre.get().setStatus(true);
            theatreRepository.save(theatre.get());
        }
        return mapper.theatreListToTheatreDtoList(theatreRepository.findAllByStatus(true));
    }

    /**
     * <p>
     * This method delete the Theatre Details with the given id
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return List<TheatreDto>
     */
    @Override
    public List<TheatreDto> deleteTheatreById(int theatreId) {
        theatreRepository.deleteById(theatreId);
        return mapper.theatreListToTheatreDtoList(theatreRepository.findAll());
    }

    /**
     * <p>
     * This method List all the Theatre Details by movie
     * </p>
     *
     * @param movieId it contains movie id
     * @return List<TheatreDto>
     */
    /*@Override
    public List<TheatreDto> findTheatresByMovieId(int movieId) throws NotFoundException {
        List<Theatre> theatreList = new ArrayList<>();
        Movie movie = mapper.movieDtoToMovie(movieService.getMovieById(movieId));
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
    }*/

    /**
     * <p>
     * This method List all the Theatre Details by city name
     * </p>
     *
     * @param city it contains city
     * @return List<TheatreDto>
     */
    public List<TheatreDto> findTheatresByLocation(String city) throws NotFoundException{
        return mapper.theatreListToTheatreDtoList(theatreRepository.findTheatreByTheatreCity(city));
    }
}
