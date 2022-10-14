package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addMovie")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        return new ResponseEntity<>(movieService.addMovie(movieDto), HttpStatus.OK);
    }

    @GetMapping("/getMovies")
    public ResponseEntity<List<MovieDto>> getMovies() throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);

    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieDto>> getMovieByGenre(@PathVariable("genre") String genre) throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovieByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/api/v1/{language}")
    public ResponseEntity<List<MovieDto>> getMovieByLanguage(@PathVariable("language") String language) throws NotFoundException {

        return new ResponseEntity<List<MovieDto>>(movieService.getMovieByLanguage(language), HttpStatus.OK);
    }

    @PutMapping("/api/v1/movie/update")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movieDto) {
        return new ResponseEntity<>(movieService.updateMovie(movieDto), HttpStatus.OK);
    }

}