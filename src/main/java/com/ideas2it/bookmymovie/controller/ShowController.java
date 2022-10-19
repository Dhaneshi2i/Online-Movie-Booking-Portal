package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.service.ShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    Logger logger = LoggerFactory.getLogger(ShowController.class);

    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    /**
     * Stores a Show object in the Database.
     *
     * @param show
     * @param theatreId
     * @param screenId
     * @return Show

     */
    @PostMapping("/add")
    public ResponseEntity<Show> addShow(@RequestBody Show show, @RequestParam(required = false) Integer theatreId,
                                        @RequestParam(required = false) Integer screenId) {

        showService.addShow(show, theatreId, screenId);
        logger.info("-------Show Added Succesfully--------");
        return new ResponseEntity<>(show, HttpStatus.CREATED);
    }

    /**
     * Removes persisted Show instance from the Database.
     *
     * @param showId
     * @return Show
     */
    @DeleteMapping("/delete/{showId}")
    public ResponseEntity<Show> removeShow(@PathVariable int showId) {

        ResponseEntity<Show> response = null;
        Show show = showService.viewShow(showId);
        if (show == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            showService.removeShow(showId);
            response = new ResponseEntity<>(show, HttpStatus.OK);
            logger.info("-------Show with ShowId " + showId + " Deleted Successfully---------");
        }
        return response;
    }

    /**
     * Updates a existing Show record in the database.
     *
     * @param show
     * @param theatreId
     * @param screenId
     * @return Show
     */
    @PutMapping("/update")
    public ResponseEntity<Show> updateShow(@RequestBody Show show, @RequestParam(required = false) Integer theatreId,
                                           @RequestParam(required = false) Integer screenId) {

        ResponseEntity<Show> response = null;
        if (show == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            showService.updateShow(show, theatreId, screenId);
            response = new ResponseEntity<>(show, HttpStatus.OK);
            logger.info("-------Show Updated Successfully---------");
        }
        return response;
    }

    /**
     * Returns the record from the database using identifier - showId
     *
     * @param showId
     * @return Show
     * @throws NotFoundException
     */
    @GetMapping("/view/{showId}")
    public ResponseEntity<Show> viewShow(@PathVariable int showId)
            throws NotFoundException {

        ResponseEntity<Show> response = null;
        try {
            Show show = showService.viewShow(showId);
            response = new ResponseEntity<>(show, HttpStatus.OK);
            logger.info("-------Show with ShowId " + showId + " Found Successfully---------");
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new NotFoundException("Show with " + showId + " id dosen't exist");
        }
        return response;
    }

    /**
     * Return's the List of Shows existing from the Database
     *
     * @return List<Show>

     */
    @GetMapping("/findall")
    public ResponseEntity<List<Show>> viewShowList() {

        logger.info("-------List Of Shows Fetched Successfully---------");
        return ResponseEntity.ok(showService.viewAllShows());
    }

    /**
     * @param theatreId
     * @return Show
     */
    @GetMapping("/show_theatre/{theatreId}")
    public ResponseEntity<List<Show>> viewShowByTheatreId(@PathVariable int theatreId) {

        logger.info("-------List Of Shows With TheatreId " + theatreId + " Fetched Successfully---------");
        return ResponseEntity.ok(showService.viewShowList(theatreId));
    }

    /**
     * @param date
     * @return List<Show>
     */
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Show>> viewShowByLocalDate(@PathVariable int date) {

        logger.info("-------List Of Shows With Date " + date + " Fetched Successfully---------");
        return ResponseEntity.ok(showService.viewShowList(date));
    }
}
