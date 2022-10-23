package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface MovieService {
    MovieDto addMovie(MovieDto movieDto);
    List<MovieDto> getMovies() throws NotFoundException;
    MovieDto getMovieById(int id);


   // List<MovieSlimDto> getMovieByLanguage(int languageId) throws NotFoundException;


    //List<MovieSlimDto> getMovieByGenre(int genreId) throws  NotFoundException;
//    List<MovieDto> viewMovieList(LocalDate date);

//    MovieDto updateMovie(MovieDto movieDto);
//
//    MovieDto deleteMovie(int id, Boolean status);


}