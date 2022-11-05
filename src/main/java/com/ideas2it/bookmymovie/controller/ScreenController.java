package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowResponseDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.ScreenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * ScreenController will get the detail from admin to
 * Create screen,List of all screens,view the screen with given Id,
 * Update screen details.
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("api/v1/screen")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }


    /**
     * <p>
     * This method is used to create Screen Details
     * </p>
     *
     * @param screenDto it contains screen dto object
     * @return ScreenDto
     */
    @PostMapping
    public ScreenDto createScreen(@Valid @RequestBody ScreenDto screenDto) {
        return screenService.createScreen(screenDto);
    }

    /**
     * <p>
     * This method List all the Screen Details
     * </p>
     *
     * @return List<ScreenDto>
     */
    @GetMapping
    public List<ScreenDto> viewScreenList() throws NotFoundException {
        return screenService.getAllScreen();

    }

    /**
     * <p>
     * This method gets the Screen Details which matches the id
     * </p>
     *
     * @param screenId it contains screen id
     * @return ScreenDto
     */
    @GetMapping("/{screenId}")
    public ScreenDto viewScreen(@PathVariable int screenId) {
        return screenService.getScreenById(screenId);
    }

    /**
     * <p>
     * This method List all the show Details by screen
     * </p>
     *
     * @param screenId it contains date
     * @return List<ShowResponseDto>
     */
    @GetMapping("/{screenId}/show")
    public List<ShowResponseDto> getShowsByScreenId(@PathVariable int screenId) {
        return screenService.getShowByScreenId(screenId);
    }

    /**
     * <p>
     * This method updates the details of the respective screen
     * </p>
     * @param screenDto it contains screenId
     * @return ScreenDto
     */

    @PatchMapping
    public ScreenDto updateScreen(@RequestBody ScreenDto screenDto) {
        return screenService.updateScreen(screenDto);
    }
}