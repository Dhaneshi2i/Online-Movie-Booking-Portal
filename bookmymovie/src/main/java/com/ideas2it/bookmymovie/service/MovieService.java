package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface MovieService {
    void addMovie(MovieDto movieDto);

    List<MovieDto> getMovies() throws NotFoundException;

    MovieDto getMovieByLanguage(String language) throws NotFoundException;

    MovieDto getMovieByGenre(String genre) throws NotFoundException, NotFoundException;

    MovieDto getMovieByScreening(String Screening) throws NotFoundException;


}
