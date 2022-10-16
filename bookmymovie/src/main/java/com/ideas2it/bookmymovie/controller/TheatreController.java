package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1/theatre")
public class TheatreController {
    private final TheatreService theatreService;
    private final ScreenService screenService;

    public TheatreController(TheatreService theatreService, ScreenService screenService) {
        this.theatreService = theatreService;
        this.screenService = screenService;
    }

    @PostMapping
    public ResponseEntity<TheatreDto> addTheatre(@RequestBody TheatreDto theatreDto) {
        return new ResponseEntity<>(theatreService.createTheatreDetails(theatreDto), HttpStatus.OK);
    }

    @PostMapping("/screen")
    public ResponseEntity<ScreenDto> addScreen(@RequestBody ScreenDto screenDto) {
        return new ResponseEntity<>(screenService.createScreenDetails(screenDto), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TheatreDto>> getAllTheatre() throws NotFoundException {
        return new ResponseEntity<>(theatreService.listAllTheatre(), HttpStatus.OK);
    }

    @GetMapping("/screen/get")
    public ResponseEntity<List<ScreenDto>> getAllScreen() throws NotFoundException {
        return new ResponseEntity<>(screenService.listAllScreen(), HttpStatus.OK);
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<List<TheatreDto>> getTheatreByCityName(@PathVariable("cityName") String cityName)
            throws NotFoundException {
        return new ResponseEntity<>(theatreService.ListTheatreByCityName(cityName), HttpStatus.OK);
    }

    @PatchMapping("/{theatreId}")
    public ResponseEntity<TheatreDto> updateTheatreStatus(@PathVariable("theatreId")
                                                              int theatreId) throws NotFoundException{
        return new ResponseEntity<>(theatreService.updateTheatreStatusDetail(theatreId), HttpStatus.OK);
    }

    @PatchMapping("/screen/{screenId}/{status}")
    public ResponseEntity<ScreenDto> updateScreenStatus(@PathVariable("screenId") int screenId,
                                                       @PathVariable("status") Boolean status) throws NotFoundException{
        return new ResponseEntity<>(screenService.updateScreenStatusDetail(screenId,status), HttpStatus.OK);
    }
}
