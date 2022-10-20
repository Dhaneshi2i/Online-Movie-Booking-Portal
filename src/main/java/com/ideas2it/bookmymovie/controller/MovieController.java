package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.dto.responseDto.MovieSlimDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    Logger logger = LoggerFactory.getLogger(MovieController.class);

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
    public MovieDto addMovie(@RequestBody MovieDto movieDto) {
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

        logger.info("-------Movie List Fetched---------");
        return movieService.getMovies();
    }

    /**
     * Returns the record from the database using identifier - movieId
     *
     * @param movieId
     * @return Movie
     * @throws NotFoundException
     */
    @GetMapping("{movieId}")
    public MovieDto getMovieById(@PathVariable int movieId)
            throws NotFoundException {

            logger.info("-------Movie With Movie id " + movieId + " Found---------");

        return movieService.getMovieById(movieId);
    }


//    @PatchMapping("/delete/{movieId}")
//    public Movie removeMovie(@PathVariable int movieId)
//            throws NotFoundException {
//
//        ResponseEntity<Movie> response = null;
//        return movieService.viewMovie(movieId);
//
//    }


//    @GetMapping("/byTheatre/{theatreId}")
//    public List<Movie> viewMovieByTheatreId(@PathVariable int theatreId)  {
//        logger.info("-------Movies With TheatreId " + theatreId + " Found---------");
//        return movieService.viewMovieList(theatreId);
//    }


//    @GetMapping("/byDate/{date}")
//    public List<Movie> viewMovieByLocalDate(
//            @RequestParam("movieDate")  LocalDate date) {
//        logger.info("-------Movies With Date " + date + " Found---------");
//        return movieService.viewMovieList(date);
//    }


    @GetMapping("genre/{genre}")
    public List<MovieSlimDto> getMovieByGenre(@PathVariable("genre") String genre) throws NotFoundException {

        return movieService.getMovieByGenre(genre);
    }

    @GetMapping("language/{language}")
    public List<MovieSlimDto> getMovieByLanguage(@PathVariable("language") String language) throws NotFoundException {

        return movieService.getMovieByLanguage(language);
    }
}