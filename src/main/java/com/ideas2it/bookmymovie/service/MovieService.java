package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.slimdto.MovieSlimDto;

import java.util.List;

public interface MovieService {
    MovieDto addMovie(MovieDto movieDto);

    List<MovieDto> getMovies() throws NotFoundException;

    MovieDto getMovieById(int id);


    List<MovieSlimDto> getMovieByLanguage(String language) throws NotFoundException;


    List<MovieSlimDto> getMovieByGenre(String genre) throws  NotFoundException;

//    MovieDto updateMovie(MovieDto movieDto);
//
//    MovieDto deleteMovie(int id, Boolean status);


}