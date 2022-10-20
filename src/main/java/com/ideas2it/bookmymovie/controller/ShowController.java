package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.service.ShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/V1/show")
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
    @PostMapping
    public Show addShow(@RequestBody Show show, @RequestParam(required = false) Integer theatreId,
                                        @RequestParam(required = false) Integer screenId) {

        showService.addShow(show, theatreId, screenId);
        logger.info("-------Show Added Succesfully--------");
        return show;
    }

    /**
     * Removes persisted Show instance from the Database.
     *
     * @param showId
     * @return Show
     */
    @DeleteMapping("/delete/{showId}")
    public Show removeShow(@PathVariable int showId) {
        return showService.getShowById(showId);

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
    public Show updateShow(@RequestBody Show show, @RequestParam(required = false) Integer theatreId,
                                           @RequestParam(required = false) Integer screenId) {


            return showService.updateShow(show, theatreId, screenId);

    }

    /**
     * Returns the record from the database using identifier - showId
     *
     * @param showId
     * @return Show
     * @throws NotFoundException
     */
    @GetMapping("/{showId}")
    public Show getShowById(@PathVariable int showId) {
            return showService.getShowById(showId);

    }

    /**
     * Return's the List of Shows existing from the Database
     *
     * @return List<Show>

     */
    @GetMapping
    public List<Show> getAllShow() {

        return showService.getAllShow();
    }

    /**
     * @param theatreId
     * @return Show
     */
    @GetMapping("/show_theatre/{theatreId}")
    public List<Show> getShowByTheatreId(@PathVariable int theatreId) {

        return showService.getShowByThreatre(theatreId);
    }

    /**
     * @param date
     * @return List<Show>
     */
    @GetMapping("/date/{date}")
    public List<Show> getShowByDate(@PathVariable LocalDate date) {

        return showService.getShowByDate(date);
    }
}
