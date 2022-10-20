package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
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
     * @throws NotFoundException
     */
    @PostMapping("/add")
    public ResponseEntity<ScreenDto> addAScreen(@RequestBody ScreenDto screen,
                                             @RequestParam(required = false) int theatreId)
            throws NotFoundException {

        logger.info("-------Screen Successfully added into Theatre " + theatreId + "---------");
        return ResponseEntity.ok(screenService.addScreen(screen, theatreId));
    }

    /**
     *
     * @return screenList
     * @throws NotFoundException
     */
    @GetMapping("/findall")
    public ResponseEntity<List<ScreenDto>> viewScreenList() throws  NotFoundException {

        logger.info("-------List Of Screens Fetched Successfully---------");
        return ResponseEntity.ok(screenService.viewScreenList());
    }

    @GetMapping("/theatre/{screenId}")
    public ResponseEntity<TheatreDto>  getTheatreById(@PathVariable int screenId) throws NotFoundException {
        ResponseEntity<TheatreDto> response = null;
        try {
            TheatreDto theatre = screenService.getTheatre(screenId);
            response = new ResponseEntity<>(theatre, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @GetMapping("/viewScreen/{screenId}")
    public ResponseEntity<ScreenDto> viewScreen(@PathVariable int screenId)
            throws NotFoundException {
        ResponseEntity<ScreenDto> response = null;
        try {
            ScreenDto screenDto = screenService.viewScreen(screenId);
            response = new ResponseEntity<>(screenDto, HttpStatus.OK);
            logger.info("-------Screen Found---------");
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new NotFoundException("Screen dosen't exist");
        }
        return response;
    }
    /**
     *
     * @param screenId
     * @throws NotFoundException
     */
    @PatchMapping("/update")
    public ResponseEntity<ScreenDto> updateScreen(@RequestParam(required = false) Integer screenId)
            throws NotFoundException {
        ResponseEntity<ScreenDto> response = null;
        ScreenDto screenDto = screenService.updateScreen(screenId);
        response = new ResponseEntity<>(screenDto, HttpStatus.OK);
        logger.info("-------Screen Updated Successfully---------");
        return response;
    }
}
