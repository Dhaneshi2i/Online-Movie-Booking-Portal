package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.ScreeningDto;
import com.ideas2it.bookmymovie.service.CastService;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import com.ideas2it.bookmymovie.service.RoleService;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.ScreeningService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/i2i/V1/admin")
public class AdminController {
    /*private GenreService genreService;
    private CastService castService;
    private LanguageService languageService;
    private RoleService roleService;
    private ScreeningService screeningService;
    private ScreenService screenService;
    private TheatreService theatreService;

    @PostMapping("/addCast")
    private CastDto addCast(@RequestBody CastDto castDto) {
        return castService.addCast(castDto);
    }

    @PostMapping("/addLanguage")
    private LanguageDto addLanguage(@RequestBody LanguageDto languageDto) {
        return languageService.addLanguage(languageDto);
    }

    @PostMapping("/addGenre")
    private GenreDto addGenre(@RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }

    @PostMapping("/addScreen")
    private ScreenDto addScreen(@RequestBody ScreenDto screenDto) {
        return screenService.addScreen(screenDto);
    }

    @PostMapping("/addScreening")
    private ScreeningDto  addScreening(@RequestBody ScreeningDto screeningDto) {
        return screeningService.addScreening(screeningDto);
    }

    @PostMapping
    public RoleDto createRoles(@RequestBody RoleDto roleDto) {
        return roleService.saveRole(roleDto);
    }*/
}
