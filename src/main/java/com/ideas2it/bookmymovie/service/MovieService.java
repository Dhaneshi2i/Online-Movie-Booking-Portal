package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface MovieService {

    /**
     * <p>
     * This method is used to create Movie Details
     * </p>
     *
     * @param movieDto it contains movie dto objects
     * @return MovieDto
     */
    MovieDto addMovie(MovieDto movieDto);

    /**
     * <p>
     * This method List all the Movie Details
     * </p>
     *
     * @return List<MovieDto>
     */
    List<MovieDto> getMovies() throws NotFoundException;

    /**
     * <p>
     * This method gets the Movie Details which matches the id
     * </p>
     *
     * @param id it contains movieId
     * @return MovieDto
     */
    MovieDto getMovieById(int id);
}