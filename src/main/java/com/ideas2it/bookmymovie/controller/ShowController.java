package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.ShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * Removes persisted Show instance from the Database.
     *
     * @param showId
     * @return Show
     */
    @DeleteMapping("/delete/{showId}")
    public void removeShow(@PathVariable int showId) {
         showService.getShowById(showId);

    }

    /**
     * Updates a existing Show record in the database.
     *
     * @param theatreId
     * @param screenId
     * @return Show
     */
    @PutMapping("/update")
    public ShowDto updateShow(@RequestBody ShowDto showDto, @RequestParam(required = false) Integer theatreId,
                                           @RequestParam(required = false) Integer screenId) {


            return showService.updateShow(showDto, theatreId, screenId);

    }

    /**
     * Returns the record from the database using identifier - showId
     *
     * @param showId
     * @return Show
     * @throws NotFoundException
     */
    @GetMapping("/{showId}")
    public ShowDto getShowById(@PathVariable int showId) {
            return showService.getShowById(showId);

    }

    /**
     * Return's the List of Shows existing from the Database
     *
     * @return List<Show>

     */
    @GetMapping
    public List<ShowDto> getAllShow() {

        return showService.getAllShow();
    }

    /**
     * @param theatreId
     * @return Show
     */
    @GetMapping("/show_theatre/{theatreId}")
    public List<ShowDto> getShowByTheatreId(@PathVariable int theatreId) {

        return showService.getShowByThreatreId(theatreId);
    }

    /**
     * @param date
     * @return List<showDto>
     */
//    @GetMapping("/date/{date}")
//    public List<Show> getShowByDate(@PathVariable LocalDate date) {
//
//        return showService.getShowByDate(date);
//    }
}
