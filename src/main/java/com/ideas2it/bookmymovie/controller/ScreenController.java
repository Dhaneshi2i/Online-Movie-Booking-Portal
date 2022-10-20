package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.ScreenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    Logger logger = LoggerFactory.getLogger(ScreenController.class);

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    /**
     *
     * @param screen
     * @param theatreId
     * @return addedScreen
     * @throws NotFoundException
     */

    @PostMapping
    public ScreenDto addScreen(@RequestBody ScreenDto screen, @RequestParam int theatreId)
            throws NotFoundException {

        logger.info("-------Screen Successfully added into Theatre " + theatreId + "---------");
        return screenService.createScreen(screen, theatreId);

    }

    /**
     *
     * @return screenList
     * @throws NotFoundException
     */
    @GetMapping
    public List<ScreenDto> viewScreenList() throws  NotFoundException {

        logger.info("-------List Of Screens Fetched Successfully---------");
        return screenService.getAllScreen();
    }

    @GetMapping("/theatre/{screenId}")
    public TheatreDto getTheatreByScreenId(@PathVariable int screenId) throws NotFoundException {
        return screenService.getTheatreByScreenId(screenId);
    }

    @GetMapping("/viewScreen/{screenId}")
    public ScreenDto viewScreen(@PathVariable int screenId) throws NotFoundException {
        ScreenDto screenDto = screenService.getScreenById(screenId);
        logger.info("-------Screen Found---------");
        return screenDto;
    }
    /**
     *
     * @param screenId
     * @throws NotFoundException
     */
    @PatchMapping("/update")
    public ScreenDto updateScreen(@RequestParam Integer screenId) throws NotFoundException {
        ScreenDto screenDto = screenService.updateScreenById(screenId);
        logger.info("-------Screen Updated Successfully---------");
        return screenDto;
    }
}
