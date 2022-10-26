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
 * This Class is to create,get,update and delete theatre Details
 */
@Slf4j
@RestController
@RequestMapping("api/v1/theatre")
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;;
    }

    @PostMapping
    public TheatreDto createTheatre(@Valid @RequestBody TheatreDto theatreDto) {
        return theatreService.createTheatre(theatreDto);
    }

    /**
     * This method is to get a list of theatre details.
     * @return listOfTheatres
     * @throws NotFoundException
     */
    @GetMapping
    public List<TheatreDto> getAllTheatres() throws NotFoundException {
        return theatreService.getAllTheatre();
    }

    /**
     *
     * @param theatreDto
     * @return inserted theatre
     * @throws NotFoundException
     */
   /* @PostMapping
    public TheatreDto addTheatre(@RequestBody TheatreDto theatreDto)
            throws NotFoundException {

        logger.info("-------Theatre Added Successfully---------");
        return theatreService.createTheatre(theatreDto);
    }
*/
    /**
     *
     * @param theatreId,theatreDto
     * @return updated theatre
     * @throws NotFoundException
     */
//    @PatchMapping("/{theatreId}")
//    public List<TheatreDto> updateTheatre(@PathVariable("theatreId") int theatreId)
//            throws  NotFoundException {
//
//        //log.info("-------Theatre Updated Successfully---------");
//        return theatreService.updateTheatreById(theatreId);
//    }

    /**
     *
     * @param theatreId
     * @return theatre by theatreId
     * @throws NotFoundException
     */
    @GetMapping("/{theatreId}")
    public TheatreDto findTheatre(@PathVariable int theatreId)
            throws  NotFoundException {
        return theatreService.findTheatreById(theatreId);
    }

    /**
     *

     * @return deleted theatre
     * @throws NotFoundException
     */
//    @DeleteMapping("/delete/{theatreId}")
//    public List<TheatreDto> deleteMoviesById(@PathVariable int theatreId)
//            throws NotFoundException {
//
//        logger.info("-------Theatre Deleted with Theatre id" + theatreId + "---------");
//        return theatreService.deleteTheatreById(theatreId);
//    }

    @GetMapping("/findbyMovie/{movieId}")
    public List<TheatreDto> findTheatreByMovieId(@PathVariable int movieId)
            throws  NotFoundException {
        return theatreService.findTheatresByMovieId(movieId);
    }
}
