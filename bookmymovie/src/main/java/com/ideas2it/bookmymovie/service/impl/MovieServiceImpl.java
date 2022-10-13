package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.repository.MovieRepository;
import com.ideas2it.bookmymovie.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    public ModelMapper mapper;
    public MovieRepository movieRepository;
    private MovieDto movieDto = null;

    public  void addMovie(MovieDto movieDto) {
        Movie movie = movieRepository.save(mapper.map(movieDto, Movie.class));

    }


    public List<MovieDto> getMovies() throws NotFoundException {
        List<Movie> movies = (List<Movie>) movieRepository.findAllByActive("active");

        if(movies.isEmpty()) {
            throw new NotFoundException("No Movie Found");
        }
            return
                    movies.stream()
                            .map(movie -> mapper.map(movie, MovieDto.class))
                            .collect(Collectors.toList());

    }


    public MovieDto getMovieByLanguage(String language) throws NotFoundException{
        Optional<Movie> movie = movieRepository.findByLangugae(language);

        if (movie.isPresent()) {
            movieDto =  mapper.map(movie.get(), MovieDto.class);
        } else {
            throw new NotFoundException("No Movie Found");
        }
        return movieDto;
    }

    public MovieDto getMovieByGenre(String genre) throws NotFoundException{
        Optional<Movie> movie = movieRepository.findByGenre(genre);

        if (movie.isPresent()) {
            movieDto =  mapper.map(movie.get(), MovieDto.class);
        } else {
            throw new NotFoundException("No Movie Found");
        }
        return movieDto;
    }


    public MovieDto getMovieByScreening(String screening) throws NotFoundException{
        Optional<Movie> movie = movieRepository.findByScreening(screening);
        if (movie.isPresent()) {
            movieDto =  mapper.map(movie.get(), MovieDto.class);
        } else {
            throw new NotFoundException("No Movie Found");
        }
        return movieDto;
    }

}
