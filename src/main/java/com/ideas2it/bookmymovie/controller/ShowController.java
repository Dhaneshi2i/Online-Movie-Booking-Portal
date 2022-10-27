package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.ShowService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    /**
     * Stores a Show object in the Database.
     *
     * @param showDto
     * @param theatreId
     * @param screenId
     * @return ShowSlimDto

     */
    @PostMapping
    public ShowDto createShow(@Valid @RequestBody ShowDto showDto,
                                  @RequestParam int theatreId, @RequestParam int screenId, @RequestParam int movieId) {
        return showService.createShow(showDto, theatreId, screenId, movieId);
    }

    /**
     * Updates an existing Show record in the database.
     *
     * @param theatreId
     * @param screenId
     * @return Show
     */
    @PutMapping
    public ShowDto updateShow(@RequestBody ShowDto showDto, @RequestParam int theatreId,
                                           @RequestParam int screenId) {
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
        return showService.getShowByTheatreId(theatreId);
    }

    /**
     * @param date
     * @return List<showDto>
     */
    @GetMapping("/date")
    public List<ShowDto> getShowByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return showService.getShowsByDate(date);
    }

}
