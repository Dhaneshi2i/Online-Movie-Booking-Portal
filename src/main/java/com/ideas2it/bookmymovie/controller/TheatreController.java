package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.TheatreService;
import lombok.extern.slf4j.Slf4j;
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
 * TheatreController will get the detail from admin to
 * Create theatre,list all theatre and list theatre by movie.
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("api/v1/theatre")
public class TheatreController {

    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;;
    }

    /**
     * <p>
     * This method is used to create Theatre Details
     * </p>
     *
     * @param theatreDto it contains theatre dto object
     * @return TheatreDto
     */
    @PostMapping
    public TheatreDto createTheatre(@Valid @RequestBody TheatreDto theatreDto) {
        return theatreService.createTheatre(theatreDto);
    }

    /**
     * <p>
     * This method List all the Theatre Details
     * </p>
     *
     * @return List<TheatreDto>
     */
    @GetMapping
    public List<TheatreDto> getAllTheatres() {
        return theatreService.getAllTheatre();
    }

    /**
     * <p>
     * This method gets TheatreId as parameter and get the Theatre Details which matches the id
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return TheatreDto
     */
    @GetMapping("/{theatreId}")
    public TheatreDto findTheatreById(@PathVariable int theatreId) {
        return theatreService.findTheatreById(theatreId);
    }

    /**
     * <p>
     * This method List all the Theatre Details by movie
     * </p>
     *
     * @param movieId it contains movie id
     * @return List<TheatreDto>
     */
    @GetMapping("/findByMovie/{movieId}")
    public List<TheatreDto> findTheatreByMovieId(@PathVariable int movieId) {
        return theatreService.findTheatresByMovieId(movieId);
    }

    /**
     * <p>
     * This method List all the Theatre Details by city name
     * </p>
     *
     * @param city it contains city
     * @return List<TheatreDto>
     */
    @GetMapping("/city/{city}")
    public List<TheatreDto> findTheatreByLocation(@PathVariable String city) {
        return theatreService.findTheatresByLocation(city);
    }

}