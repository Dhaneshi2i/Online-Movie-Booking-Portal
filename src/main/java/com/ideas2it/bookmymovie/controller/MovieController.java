package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Stores a Movie object in the Database.
     *
     * @param movieDto
     * @return MovieDto
     * @throws NotFoundException
     */
    @PostMapping
    //@RolesAllowed("Admin")
    public MovieDto createMovie(@Valid @RequestBody MovieDto movieDto) {
        return movieService.addMovie(movieDto);
    }

    /**
     * Return's the List of Movies from the Database
     *
     * @return List<Movie>
     * @throws NotFoundException
     */
    @GetMapping
    public List<MovieDto> getMovies() throws NotFoundException {
//        log.info("-------Movie List Fetched---------");
        return movieService.getMovies();
    }

    /**
     * Returns the record from the database using identifier - movieId
     *
     * @param movieId
     * @return Movie
     * @throws NotFoundException
     */
    @GetMapping("/{movieId}")
    public MovieDto getMovieById(@PathVariable int movieId) throws NotFoundException {
            //log.info("-------Movie With Movie id " + movieId + " Found---------");
        return movieService.getMovieById(movieId);
    }

    /*@GetMapping("/date")
    public List<MovieDto> viewMovieByLocalDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date ) {
        //log.info("-------Movies With Date " + date + " Found---------");
        return movieService.viewMovieList(date);
    }*/

//    @GetMapping("/byTheatre/{theatreId}")
//    public List<Movie> viewMovieByTheatreId(@PathVariable int theatreId)  {
//        logger.info("-------Movies With TheatreId " + theatreId + " Found---------");
//        return movieService.viewMovieList(theatreId);
//    }

}