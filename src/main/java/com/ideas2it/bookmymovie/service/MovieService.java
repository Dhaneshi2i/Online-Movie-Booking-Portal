package com.ideas2it.bookmymovie.service;


import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    Movie addMovie(Movie movie) throws NotFoundException;

     Movie removeMovie(int movieId) throws NotFoundException;

     Movie updateMovie(Movie movie) throws NotFoundException;

    Movie addMovieToShow(Movie movie, Integer showId) throws NotFoundException;

     Movie viewMovie(int movieId) throws NotFoundException;

     List<Movie> viewMovieList() throws NotFoundException;

     List<Movie> viewMovieList(int theatreId);

     List<Movie> viewMovieList(LocalDate date);
}

