package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.service.CastService;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * AdminController class  will create the new cast, language,
 *
 *
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private GenreService genreService;
    private CastService castService;
    private LanguageService languageService;

    public AdminController(GenreService genreService, CastService castService, LanguageService languageService) {
        this.genreService = genreService;
        this.castService = castService;
        this.languageService = languageService;
    }

    @PostMapping("/cast")
    public CastDto createCast(@Valid @RequestBody CastDto castDto) {
        return castService.addCast(castDto);
    }

    @PostMapping("/language")
    public LanguageDto createLanguage(@Valid @RequestBody LanguageDto languageDto) {
        return languageService.addLanguage(languageDto);
    }

    @PostMapping("/genre")
    public GenreDto createGenre(@Valid @RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }

}









    /*@GetMapping("/cast/{id}")
    public CastDto getCast(@PathVariable String name) throws NotFoundException {
        return castService.getCastByName(name);
    }*/

/*    @GetMapping("/language/{name}")
    public LanguageDto getLanguage(@PathVariable String name) {
        return languageService.getLanguageByName(name);
    }

    @GetMapping("/genre/{name}")
    public GenreDto getGenre(@PathVariable String name) {
        return genreService.getGenreByName(name);
    }*/