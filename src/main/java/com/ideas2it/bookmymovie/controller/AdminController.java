package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.CastService;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/admin")
public class AdminController {
    private final GenreService genreService;
    private final CastService castService;
    private final LanguageService languageService;

    public AdminController(GenreService genreService, CastService castService, LanguageService languageService) {
        this.genreService = genreService;
        this.castService = castService;
        this.languageService = languageService;
    }

    @PostMapping("/Cast")
    public CastDto addCast(@RequestBody CastDto castDto) {
        return castService.addCast(castDto);
    }

    @GetMapping("/cast/{name}")
    public CastDto getCast(@PathVariable String name) throws NotFoundException {
        return castService.getCastByName(name);
    }

    @PostMapping("/Language")
    public LanguageDto addLanguage(@RequestBody LanguageDto languageDto) {
        return languageService.addLanguage(languageDto);
    }

    @GetMapping("/language/{name}")
    public LanguageDto getLanguage(@PathVariable String name) {
        return languageService.getLanguageByName(name);
    }

    @PostMapping("/Genre")
    public GenreDto addGenre(@RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }

    @GetMapping("/genre/{name}")
    public GenreDto getGenre(@PathVariable String name) {
        return genreService.getGenreByName(name);
    }

}
