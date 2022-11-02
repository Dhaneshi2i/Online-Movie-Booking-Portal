package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * MovieController will get the detail from admin to
 * Create movie
 * List all movie and view movie by specified id for the customer
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * <p>
     * This method is used to create Movie Details
     * </p>
     *
     * @param movieDto it contains movie dto objects
     * @return MovieDto
     */
    @PostMapping
    public MovieDto createMovie(@Valid @RequestBody MovieDto movieDto) {
        return movieService.addMovie(movieDto);
    }

    /**
     * <p>
     * This method List all the Movie Details
     * </p>
     *
     * @return List<MovieDto>
     */
    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getMovies();
    }

    /**
     * <p>
     * This method gets the Movie Details which matches the id
     * </p>
     *
     * @param movieId it contains movieId
     * @return MovieDto
     */
    @GetMapping("/{movieId}")
    public MovieDto getMovieById(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }

}