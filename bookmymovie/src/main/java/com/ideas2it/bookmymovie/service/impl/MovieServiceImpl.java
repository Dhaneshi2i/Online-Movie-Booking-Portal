package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.repository.MovieRepository;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import com.ideas2it.bookmymovie.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    public final ModelMapper mapper;

    public final MovieRepository movieRepository;

    private final GenreService genreService;

    private final LanguageService languageService;

    public MovieServiceImpl(ModelMapper mapper, MovieRepository movieRepository, GenreService genreService, LanguageService languageService) {
        this.mapper = mapper;
        this.movieRepository = movieRepository;
        this.genreService = genreService;
        this.languageService = languageService;
    }

    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = movieRepository.save(mapper.map(movieDto, Movie.class));
        return mapper.map(movie, MovieDto.class);
    }

    public List<MovieDto> getMovies() throws NotFoundException {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();

        if(movies.isEmpty()) {
            throw new NotFoundException("No Movie Found");
        }
            return
                    movies.stream()
                            .map(movie -> mapper.map(movie, MovieDto.class))
                            .collect(Collectors.toList());

    }


    public List<MovieDto> getMovieByLanguage(String language) throws NotFoundException{
        LanguageDto movieByLanguage = languageService.getLanguageByName(language);
        return movieByLanguage.getMoviesDto();
    }

    public List<MovieDto> getMovieByGenre(String genre) throws NotFoundException{
        GenreDto movieByGenre = genreService.getGenreByName(genre);
        return movieByGenre.getMoviesDto();
    }

    public MovieDto updateMovie(MovieDto movieDto) {
        Movie movie = movieRepository.save(mapper.map(movieDto, Movie.class));
        return mapper.map(movie, MovieDto.class);
    }

    public MovieDto deleteMovie(int id, Boolean status) {
        Movie movie = movieRepository.getById(id);
        movie.setModifiedDate(LocalDate.now());
        movie.setStatus(status);
        return mapper.map(movieRepository.save(movie), MovieDto.class);
    }
}