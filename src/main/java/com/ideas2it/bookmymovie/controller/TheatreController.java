package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.web.bind.annotation.*;

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

@RestController
@RequestMapping("api/v1/theatre")
public class TheatreController {

    private final TheatreService theatreService;

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
    public List<TheatreDto> getAllTheatres(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return theatreService.getAllTheatre(pageNumber, pageSize);
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
     * This method List all the Theatre Details by city name
     * </p>
     *
     * @param city it contains city
     * @return List<TheatreDto>
     */
    @GetMapping("/get-by-city/{city}")
    public List<TheatreDto> findTheatreByLocation(@PathVariable String city) {
        return theatreService.findTheatresByLocation(city);
    }

}