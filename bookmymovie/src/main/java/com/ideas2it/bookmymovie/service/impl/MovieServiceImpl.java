package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.repository.MovieRepository;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import com.ideas2it.bookmymovie.service.MovieService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    public final MapStructMapper mapper;

    public final MovieRepository movieRepository;

    private final GenreService genreService;

    private final LanguageService languageService;

    public MovieServiceImpl(MapStructMapper mapper, MovieRepository movieRepository, GenreService genreService, LanguageService languageService) {
        this.mapper = mapper;
        this.movieRepository = movieRepository;
        this.genreService = genreService;
        this.languageService = languageService;
    }

    public MovieDto addMovie(MovieDto movieDto) {
        return mapper.movieToMovieDto(movieRepository.save(mapper.movieDtoToMovie(movieDto)));
    }

    public List<MovieDto> getMovies() throws NotFoundException {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();

        if(movies.isEmpty()) {
            throw new NotFoundException("No Movie Found");
        }
            return
                    movies.stream()
                            .map(movie -> mapper.movieToMovieDto(movie))
                            .collect(Collectors.toList());
    }


    public List<MovieDto> getMovieByLanguage(String language) throws NotFoundException{
        LanguageDto movieByLanguage = languageService.getLanguageByName(language);
        return movieByLanguage.getMovies();
    }

    public List<MovieDto> getMovieByGenre(String genre) throws NotFoundException{
        GenreDto movieByGenre = genreService.getGenreByName(genre);
        return movieByGenre.getMovies();
    }

    public MovieDto updateMovie(MovieDto movieDto) {
        Movie movie = movieRepository.save(mapper.movieDtoToMovie(movieDto));
        return mapper.movieToMovieDto(movie);
    }

    public MovieDto deleteMovie(int id, Boolean status) {
        Movie movie = movieRepository.getById(id);
        movie.setModifiedDate(LocalDate.now());
        movie.setStatus(status);
        return mapper.movieToMovieDto(movieRepository.save(movie));
    }
}