package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.responseDto.TheatreSlimDto;
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

    private final TheatreRepository theatreRepository;

    private final MovieService movieService;

    private final MapStructMapper mapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository,
                              MovieService movieService, MapStructMapper mapper) {
        this.theatreRepository = theatreRepository;
        this.movieService = movieService;
        this.mapper = mapper;
    }

    /**
     * This method gets theatreDto object as parameter to create Theatre Details
     *
     * @param theatreDto is passed as argument to add these value to the database.
     */
    @Override
    public TheatreDto createTheatre(TheatreDto theatreDto) throws NotFoundException {
        return mapper.theatreToTheatreDto(theatreRepository.save(mapper.theatreDtoToTheatre(theatreDto)));
    }

    /**
     * This method List all the Theatre Details that are present in Database
     *
     * @return List<TheatreDto> which will have all the Theatre Details which are present in
     * the database.
     */
    @Override
    public List<TheatreDto> getAllTheatre() throws NotFoundException {
        List<Theatre> theatres = theatreRepository.findAllByStatus(true);
        if (theatres.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return theatres.stream().
                map(theatre -> mapper.theatreToTheatreDto(theatre)).collect(Collectors.toList());
    }

    /**
     * This method gets TheatreId as parameter and get the Theatre Details which matches the id
     *
     * @param theatreId is passed as argument to fetch those from the database.
     * @return TheatreDto which is fetched from database with the param
     */
    @Override
    public TheatreSlimDto findTheatreById(int theatreId) throws NotFoundException{
        if (theatreRepository.existsById(theatreId)) {
            Optional<Theatre> theatre = theatreRepository.findById(theatreId);
            if(theatre.isPresent()){
                return mapper.theatreToTheatreSlimDto(theatre.get());
            }
        }
        throw new NotFoundException("Theatre details with the given id is not found");
    }

    /**
     * This method gets TheatreId as parameter and update the Theatre Details
     *
     * @param theatreId is passed as argument to get those value from the database.
     * @return List of theatre details after update
     */
    @Override
    public List<TheatreDto> updateTheatreById(int theatreId) {
        Optional<Theatre> theatre = theatreRepository.findById(theatreId);
        if(theatre.isPresent()) {
            theatre.get().setStatus(false);
            theatreRepository.save(theatre.get());
        }
        return mapper.theatreListToTheatreDtoList(theatreRepository.findAllByStatus(true));
    }

    /**
     * This method gets TheatreId as parameter and delete the Theatre Details with the given id
     *
     * @param theatreId is passed as argument to delete those value from the database.
     * @return List of theatre details after deletion
     */
    @Override
    public List<TheatreDto> deleteTheatreById(int theatreId) {
        theatreRepository.deleteById(theatreId);
        return mapper.theatreListToTheatreDtoList(theatreRepository.findAll());
    }

    /**
     * This method List all the Theatre Details by movie that are present in Database
     *
     * @param movieId is passed to categorize the theatre Details by Movie
     * @return List<TheatreDto> which will have the list of all the details of theatre
     * which was categorized by movie
     */
    @Override
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
    }
}
