package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Language;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.repository.MovieRepository;
import com.ideas2it.bookmymovie.service.CastService;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import com.ideas2it.bookmymovie.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

 @Service
    public class MovieServiceImpl implements MovieService {
     private final MapStructMapper mapper;

     private final MovieRepository movieRepository;

     private final GenreService genreService;

     private final LanguageService languageService;
     private final CastService castService;

     public MovieServiceImpl(MapStructMapper mapper, MovieRepository movieRepository, GenreService genreService,
                             LanguageService languageService, CastService castService) {
         this.mapper = mapper;
         this.movieRepository = movieRepository;
         this.genreService = genreService;
         this.languageService = languageService;
         this.castService = castService;
     }

     public MovieDto addMovie(MovieDto movieDto) {
         Movie movie = new Movie();
         if (null != movieDto) {
             List<CastDto> casts = new ArrayList<>();
             for (CastDto cast : movieDto.getCasts()) {
                 casts.add(castService.getByCastId(cast.getCastId()));
                 System.out.println(castService.getByCastId(cast.getCastId()).getName());
             }
             movieDto.setCasts(casts);
             List<LanguageDto> languages = new ArrayList<>();
             for (LanguageDto language : movieDto.getLanguages()) {
                 languages.add(languageService.getByLanguageId(language.getLanguageId()));
             }
             movieDto.setLanguages(languages);

             List<GenreDto> genres = new ArrayList<>();
             for (GenreDto genre : movieDto.getGenres()) {
                 genres.add(genreService.getByGenreId(genre.getGenreId()));
             }
             movieDto.setGenres(genres);
             movie = mapper.movieDtoToMovie(movieDto);
         }

         return mapper.movieToMovieDto(movieRepository.save(movie));
     }

     public List<MovieDto> getMovies() throws NotFoundException {
         List<Movie> movies = movieRepository.findAll();

         if (movies.isEmpty()) {
             throw new NotFoundException("No Movie Found");
         }
         return
                 movies.stream()
                         .map(mapper::movieToMovieDto)
                         .collect(Collectors.toList());
     }

     public MovieDto getMovieById(int movieId) {
         if (movieRepository.existsById(movieId)) {
             Optional<Movie> movie = movieRepository.findById(movieId);
             if(movie.isPresent()){
                 return mapper.movieToMovieDto(movie.get());
             }
         }
         throw new NotFoundException("Theatre details with the given id is not found");
     }

  }

