package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.responseDto.CastResponseDto;
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
 * AdminController will get the detail from admin to
 * Create genre, language and cast
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final GenreService genreService;
    private final CastService castService;
    private final LanguageService languageService;

    public AdminController(GenreService genreService, CastService castService, LanguageService languageService) {
        this.genreService = genreService;
        this.castService = castService;
        this.languageService = languageService;
    }

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param castDto it contains cast dto objects
     * @return CastResponseDto
     */
    @PostMapping("/cast")
    public CastDto createCast(@Valid @RequestBody CastDto castDto) {
        return castService.addCast(castDto);
    }

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param languageDto it contains language dto objects.
     * @return LanguageDto
     */
    @PostMapping("/language")
    public LanguageDto createLanguage(@Valid @RequestBody LanguageDto languageDto) {
        return languageService.addLanguage(languageDto);
    }

    /**
     * <p>
     * This method is used to create Genre Details
     * </p>
     *
     * @param genreDto it contains genre dto objects
     * @return GenreDto
     */
    @PostMapping("/genre")
    public GenreDto createGenre(@Valid @RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }

}
