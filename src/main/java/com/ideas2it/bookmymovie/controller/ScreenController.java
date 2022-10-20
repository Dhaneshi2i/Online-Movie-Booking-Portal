package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.ScreenNotFoundException;
import com.ideas2it.bookmymovie.service.ScreenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @throws ScreenNotFoundException
     */
    @PostMapping
    public ScreenDto addAScreen(@RequestBody ScreenDto screen,
                                             @RequestParam(required = false) int theatreId)
            throws ScreenNotFoundException {

        logger.info("-------Screen Successfully added into Theatre " + theatreId + "---------");
        return screenService.addScreen(screen, theatreId);
    }

    /**
     *
     * @return screenList
     * @throws ScreenNotFoundException
     */
    @GetMapping
    public List<ScreenDto> viewScreenList() throws  ScreenNotFoundException {

        logger.info("-------List Of Screens Fetched Successfully---------");
        return screenService.viewScreenList();
    }

    @GetMapping("/theatre/{screenId}")
    public TheatreDto  getTheatreById(@PathVariable int screenId) throws ScreenNotFoundException {

        try {
            TheatreDto theatre = screenService.getTheatre(screenId);

        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @GetMapping("/viewScreen/{screenId}")
    public ResponseEntity<ScreenDto> viewScreen(@PathVariable int screenId)
            throws ScreenNotFoundException {
        ResponseEntity<ScreenDto> response = null;
        try {
            ScreenDto screenDto = screenService.viewScreen(screenId);
            response = new ResponseEntity<>(screenDto, HttpStatus.OK);
            logger.info("-------Screen Found---------");
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ScreenNotFoundException("Screen dosen't exist");
        }
        return response;
    }
    /**
     *
     * @param screenId
     * @throws ScreenNotFoundException
     */
    @PatchMapping("/update")
    public ResponseEntity<ScreenDto> updateScreen(@RequestParam(required = false) Integer screenId)
            throws ScreenNotFoundException {
        ResponseEntity<ScreenDto> response = null;
        ScreenDto screenDto = screenService.updateScreen(screenId);
        response = new ResponseEntity<>(screenDto, HttpStatus.OK);
        logger.info("-------Screen Updated Successfully---------");
        return response;
    }
}
