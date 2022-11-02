package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.service.GenreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    /**
     * <p>
     * This method is used to create Genre Details
     * </p>
     *
     * @param genreDto it contains genre dto objects
     * @return GenreDto
     */
    @PostMapping
    public GenreDto createGenre(@Valid @RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }
}
