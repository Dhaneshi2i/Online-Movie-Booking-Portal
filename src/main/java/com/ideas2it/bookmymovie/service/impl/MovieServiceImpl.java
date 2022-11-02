package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.repository.MovieRepository;
import com.ideas2it.bookmymovie.service.CastService;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import com.ideas2it.bookmymovie.service.MovieService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

     /**
      * <p>
      * This method is used to create Movie Details
      * </p>
      *
      * @param movieDto it contains movie dto objects
      * @return MovieDto
      */
     public MovieDto addMovie(MovieDto movieDto) {
         Movie movie = new Movie();
         if (null != movieDto) {
             List<CastDto> casts = new ArrayList<>();
             for (CastDto cast : movieDto.getCasts()) {
                 casts.add(castService.getByCastId(cast.getId()));
             }
             movieDto.setCasts(casts);
             List<LanguageDto> languages = new ArrayList<>();
             for (LanguageDto language : movieDto.getLanguages()) {
                 languages.add(languageService.getByLanguageId(language.getId()));
             }
             movieDto.setLanguages(languages);

             List<GenreDto> genres = new ArrayList<>();
             for (GenreDto genre : movieDto.getGenres()) {
                 genres.add(genreService.getByGenreId(genre.getId()));
             }
             movieDto.setGenres(genres);
             movie = mapper.movieDtoToMovie(movieDto);
         }

         return mapper.movieToMovieDto(movieRepository.save(movie));
     }

     /**
      * <p>
      * This method List all the Movie Details
      * </p>
      *
      * @return List<MovieDto>
      */
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

     /**
      * <p>
      * This method gets the Movie Details which matches the id
      * </p>
      *
      * @param movieId it contains movieId
      * @return MovieDto
      */
     @Cacheable(value = "movie")
     public MovieDto getMovieById(int movieId) throws NotFoundException{
         if (movieRepository.existsById(movieId)) {
             System.out.println(movieId);
             Movie movie = movieRepository.findByMovieId(movieId);
             System.out.println("id: " + movie.getMovieId());
                 return mapper.movieToMovieDto(movie);
         }
         throw new NotFoundException("No movie found");
     }

  }

