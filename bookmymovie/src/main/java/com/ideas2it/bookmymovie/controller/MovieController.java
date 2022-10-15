package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("genre/{genre}")
    public ResponseEntity<List<MovieDto>> getMovieByGenre(@PathVariable("genre") String genre) throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovieByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("language/{language}")
    public ResponseEntity<List<MovieDto>> getMovieByLanguage(@PathVariable("language") String language) throws NotFoundException {

        return new ResponseEntity<List<MovieDto>>(movieService.getMovieByLanguage(language), HttpStatus.OK);
    }

    @PutMapping("/updateMovie")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movieDto) {
        return new ResponseEntity<>(movieService.updateMovie(movieDto), HttpStatus.OK);
    }

    @PatchMapping("delete/{id}/{status}")
    public ResponseEntity<MovieDto> updateEmployeePartially(@PathVariable int id, @PathVariable boolean status) {

        return new ResponseEntity<>(movieService.deleteMovie(id, status), HttpStatus.OK);

    }
}