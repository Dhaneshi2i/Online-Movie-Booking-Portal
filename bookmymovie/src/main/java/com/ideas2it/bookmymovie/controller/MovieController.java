package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/movie")
@RestController
public class MovieController {

    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@Valid @RequestBody MovieDto branchDto) {
        return new ResponseEntity<>(movieService.addBranch(branchDto), HttpStatus.OK);
    }

    @GetMapping("api/v1/movie/add")
    public ResponseEntity<List<MovieDto>> getMovies() throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);

    }

    @GetMapping("/api/v1/{genre}")
    public ResponseEntity<MovieDto> getMovieByGenre(@PathVariable("genre") int id) throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovieByGenre(genre), HttpStatus.OK);
    }
    @GetMapping("/api/v1/{language}")
    public ResponseEntity<MovieDto> getMovieByLanguage(@PathVariable("genre") int id) throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovieByLanguage(language), HttpStatus.OK);
    }

    @PatchMapping("/api/v1/movie/{id}/{language}")
    public ResponseEntity<MovieDto> updateMovie(@Valid @RequestBody MovieDto movieDto) {
        return new ResponseEntity<>(movieService.updateMovie(movieDto), HttpStatus.OK);
    }



    }


}
