package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.service.ShowService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * ShowController will get the show detail to
 * Create shows for the user,list all shows and
 * Update shows with given status
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    /**
     * <p>
     * This method is used to create Show Details
     * </p>
     *
     * @param showDto it contains show dto objects
     * @return ShowDto
     */
    @PostMapping
    public ShowDto createShow(@Valid @RequestBody ShowDto showDto) {
        return showService.createShow(showDto);
    }

    /**
     * <p>
     * This method updates Show Details
     * </p>
     *
     * @param showDto   it contains show dto objects
     * @param showId it contains theatre id
     * @return ShowDto
     */
    @PatchMapping("{showId}")
    public List<ShowDto> updateShow(@RequestBody ShowDto showDto,@PathVariable int showId) {
        return showService.updateShow(showDto, showId);
    }

    /**
     * <p>
     * This method gets the Show Details with given id
     * </p>
     *
     * @param showId it contains show id
     * @return ShowDto
     */
    @GetMapping("/{showId}")
    public ShowDto getShowById(@PathVariable int showId) {
        return showService.getShowById(showId);
    }

    /**
     * <p>
     * This method List all the Show Details
     * </p>
     *
     * @return List<ShowDto>
     */
    @GetMapping
    public List<ShowDto> getAllShow() {
        return showService.getAllShow();
    }

    /**
     * <p>
     * This method List all the Screen Details by Theatre
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return List<ShowDto>
     */
    @GetMapping("/{theatreId}")
    public List<ShowDto> getShowByTheatreId(@PathVariable int theatreId) {
        return showService.getShowByTheatreId(theatreId);
    }

    /**
     * <p>
     * This method List all the Screen Details by Date
     * </p>
     *
     * @param date it contains date
     * @return List<ShowDto>
     */
    @GetMapping("/date")
    public List<ShowDto> getShowByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return showService.getShowsByDate(date);
    }

}