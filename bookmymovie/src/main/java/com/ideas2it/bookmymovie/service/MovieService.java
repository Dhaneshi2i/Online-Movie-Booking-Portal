package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface MovieService {
    MovieDto addMovie(MovieDto movieDto);

    List<MovieDto> getMovies() throws NotFoundException;

    List<MovieDto> getMovieByLanguage(String language) throws NotFoundException;

    List<MovieDto> getMovieByGenre(String genre) throws  NotFoundException;

    MovieDto updateMovie(MovieDto movieDto);


}
