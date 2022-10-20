package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This Class is to create,get,update and delete theatre Details
 */
@RestController
@RequestMapping("/theatre")
public class TheatreController {
    Logger logger = LoggerFactory.getLogger(TheatreController.class);

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;;
    }


    /**
     * This method is to get a list of theatre details.
     * @return listOfTheatres
     * @throws NotFoundException
     */
    @GetMapping
    public List<TheatreDto> getAllTheatres() throws NotFoundException {

        logger.info("-------Theatre List Fetched---------");
        return theatreService.getAllTheatre();
    }

    /**
     *
     * @param theatreDto
     * @return inserted theatre
     * @throws NotFoundException
     */
    @PostMapping
    public TheatreDto addTheatre(@RequestBody TheatreDto theatreDto)
            throws NotFoundException {

        logger.info("-------Theatre Added Successfully---------");
        return theatreService.createTheatre(theatreDto);
    }

    /**
     *
     * @param theatreId,theatreDto
     * @return updated theatre
     * @throws NotFoundException
     */
    @PatchMapping("/{theatreId}")
    public List<TheatreDto> updateTheatre(@PathVariable("theatreId") int theatreId)
            throws  NotFoundException {

        logger.info("-------Theatre Updated Successfully---------");
        return theatreService.updateTheatreById(theatreId);
    }

    /**
     *
     * @param theatreId
     * @return theatre by theatreId
     * @throws NotFoundException
     */
    @GetMapping("/find/{theatreId}")
    public TheatreDto findTheatre(@PathVariable int theatreId)
            throws  NotFoundException {

        logger.info("-------Theatre Found with Theatre id" + theatreId + "---------");
        return theatreService.findTheatreById(theatreId);
    }

    /**
     *
     * @param theatreId
     * @return deleted theatre
     * @throws NotFoundException
     */
    @DeleteMapping("/delete/{theatreId}")
    public List<TheatreDto> deleteMoviesById(@PathVariable int theatreId)
            throws NotFoundException {

        logger.info("-------Theatre Deleted with Theatre id" + theatreId + "---------");
        return theatreService.deleteTheatreById(theatreId);
    }

    @GetMapping("/findbyMovie/{movieId}")
    public List<TheatreDto> findTheatreByMovieId(@PathVariable int movieId)
            throws  NotFoundException {
        return theatreService.findTheatresByMovie(movieId);
    }
}
