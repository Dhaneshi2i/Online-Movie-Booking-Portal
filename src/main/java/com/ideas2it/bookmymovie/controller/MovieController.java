package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService moviesService;

    /**
     * Stores a Movie object in the Database.
     *
     * @param movie
     * @return Movie
     * @throws NotFoundException
     */
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie)
            throws NotFoundException {
        movie = moviesService.addMovie(movie);
        logger.info("-------Movie Added Successfully---------");
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    /**
     * Updates a existing Movie record in the database.
     *
     * @param movie
     * @return Movie
     * @throws NotFoundException
     */
    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie)
            throws NotFoundException {

        ResponseEntity<Movie> response = null;
        if (movie == null) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            movie = moviesService.updateMovie(movie);
            response = new ResponseEntity<>(movie, HttpStatus.OK);
            logger.info("-------Movie Updated Successfully---------");
        }
        return response;
    }

    @PutMapping("/map")
    public ResponseEntity<Movie> addToShow(@RequestBody Movie movie,@RequestParam(required = false) Integer showId)
            throws NotFoundException {

        ResponseEntity<Movie> response = null;
        if (movie == null) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            movie = moviesService.addMovieToShow(movie,showId);
            response = new ResponseEntity<>(movie, HttpStatus.OK);
            logger.info("-------Movie Updated Successfully---------");
        }
        return response;
    }




    /**
     * Return's the List of Movies from the Database
     *
     * @return List<Movie>
     * @throws NotFoundException
     */
    @GetMapping("/findall")
    public ResponseEntity<List<Movie>> viewMovieList() throws NotFoundException {

        logger.info("-------Movie List Fetched---------");
        return ResponseEntity.ok(moviesService.viewMovieList());
    }

    /**
     * Returns the record from the database using identifier - movieId
     *
     * @param movieId
     * @return Movie
     * @throws NotFoundException
     */
    @GetMapping("/viewMovie/{movieId}")
    public ResponseEntity<Movie> viewMovie(@PathVariable int movieId)
            throws NotFoundException {

        ResponseEntity<Movie> response = null;
        try {
            Movie movie = moviesService.viewMovie(movieId);
            response = new ResponseEntity<>(movie, HttpStatus.OK);
            logger.info("-------Movie With Movie id " + movieId + " Found---------");
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new NotFoundException("Movie with " + movieId + " id dosen't exist");
        }
        return response;
        // return ResponseEntity.ok(moviesService.viewMovie(movieId));
    }

    /**
     * Removes persisted Movie instance from the Database.
     *
     * @param movieId
     * @return Movie
     * @throws NotFoundException
     */
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Movie> removeMovie(@PathVariable int movieId)
            throws NotFoundException {

        ResponseEntity<Movie> response = null;
        Movie movie = moviesService.viewMovie(movieId);
        if (movie == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            moviesService.removeMovie(movieId);
            response = new ResponseEntity<>(movie, HttpStatus.OK);
            logger.info("-------Movie With Movie id " + movieId + " Deleted---------");
        }
        return response;
    }

    /**
     * Displays List of movies based on the TheatreId.
     *
     * @param theatreId
     * @return Movie
     */
    @GetMapping("/byTheatre/{theatreId}")
    public List<Movie> viewMovieByTheatreId(@PathVariable int theatreId)  {
        logger.info("-------Movies With TheatreId " + theatreId + " Found---------");
        return moviesService.viewMovieList(theatreId);
    }

    /**
     * Returns the list of Movies based on the Date.
     *
     * @param date
     * @return Movie
     */
    @GetMapping("/byDate/{date}")
    public List<Movie> viewMovieByLocalDate(
            @RequestParam("movieDate")  LocalDate date) {
        logger.info("-------Movies With Date " + date + " Found---------");
        return moviesService.viewMovieList(date);
    }

}
