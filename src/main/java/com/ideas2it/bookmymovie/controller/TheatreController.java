package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.TheatreNotFoundException;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    Logger logger = LoggerFactory.getLogger(TheatreController.class);

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;;
    }


    /**
     *
     * @return listOfTheatres
     * @throws TheatreNotFoundException
     */
    @GetMapping
    public ResponseEntity<List<TheatreDto>> getAllTheatres() throws TheatreNotFoundException {

        logger.info("-------Theatre List Fetched---------");
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    /**
     *
     * @param theatreDto
     * @return inserted theatre
     * @throws TheatreNotFoundException
     */
    @PostMapping
    public ResponseEntity<TheatreDto> addTheatre(@RequestBody TheatreDto theatreDto)
            throws TheatreNotFoundException {

        logger.info("-------Theatre Added Successfully---------");
        return new ResponseEntity<>(theatreService.addTheatre(theatreDto), HttpStatus.CREATED);
    }

    /**
     *
     * @param theatreId,theatreDto
     * @return updated theatre
     * @throws TheatreNotFoundException
     */
    @PatchMapping("/{theatreId}")
    public List<TheatreDto> updateTheatre(@PathVariable("theatreId") int theatreId)
            throws  TheatreNotFoundException {

        logger.info("-------Theatre Updated Successfully---------");
        return theatreService.updateTheatre(theatreId);
    }

    /**
     *
     * @param theatreId
     * @return theatre by theatreId
     * @throws TheatreNotFoundException
     */
    @GetMapping("/find/{theatreId}")
    public ResponseEntity<TheatreDto> findTheatre(@PathVariable int theatreId)
            throws  TheatreNotFoundException {

        logger.info("-------Theatre Found with Theatre id" + theatreId + "---------");
        return ResponseEntity.ok(theatreService.findTheatres(theatreId));
    }

    /**
     *
     * @param theatreId
     * @return deleted theatre
     * @throws TheatreNotFoundException
     */
    @DeleteMapping("/delete/{theatreId}")
    public List<TheatreDto> deleteMoviesById(@PathVariable int theatreId)
            throws TheatreNotFoundException {

        logger.info("-------Theatre Deleted with Theatre id" + theatreId + "---------");
        return theatreService.deleteTheatreById(theatreId);
    }

//    @GetMapping("/findbyMovie/{movieId}")
//    public ResponseEntity<List<TheatreDto>> findTheatreByMovieId(@PathVariable int movieId)
//            throws  TheatreNotFoundException {
//        return ResponseEntity.ok(theatreService.findTheatresByMovie(movieId));
//    }
}
