package com.ideas2it.bookmymovie.controller;


import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.service.LanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
@RequestMapping("/api/v1/language")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param languageDto it contains language dto objects.
     * @return LanguageDto
     */
    @PostMapping
    public LanguageDto createLanguage(@Valid @RequestBody LanguageDto languageDto) {
        return languageService.addLanguage(languageDto);
    }

    @GetMapping
    public List<LanguageDto> getAllLanguages() {
        return languageService.getAllLanguages();
    }

}
