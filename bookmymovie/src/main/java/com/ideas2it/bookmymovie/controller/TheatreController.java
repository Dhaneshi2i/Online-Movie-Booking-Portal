package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1/theatre")
public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public ResponseEntity<TheatreDto> addTheatre(@RequestBody TheatreDto theatreDto) {
        return new ResponseEntity<>(theatreService.createTheatreDetails(theatreDto), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TheatreDto>> getAllTheatre() throws NotFoundException {
        return new ResponseEntity<>(theatreService.listAllTheatre(), HttpStatus.OK);
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<List<TheatreDto>> getTheatreByCityName(@PathVariable("cityName") String cityName)
            throws NotFoundException {
        return new ResponseEntity<>(theatreService.ListTheatreByCityName(cityName), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<TheatreDto> updateTheatre(@RequestBody TheatreDto theatreDto) {
        return new ResponseEntity<>(theatreService.updateTheatreDetails(theatreDto), HttpStatus.OK);
    }
}
