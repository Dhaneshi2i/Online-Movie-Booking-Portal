package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.LanguageDto;

import java.util.List;

/**
 * <p>
 * This {@Code LanguageService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface LanguageService {

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param languageDto it contains language dto objects.
     * @return LanguageDto
     */
    LanguageDto addLanguage(LanguageDto languageDto);

    /**
     * <p>
     * This method gets the language Details which matches the id
     * </p>
     *
     * @param languageId it contains language id
     * @return LanguageDto
     */
    LanguageDto getByLanguageId(int languageId);

    /**
     * <p>
     * This method returns list of all languages
     * </p>
     * @return List<LanguageDto>
     */
    List<LanguageDto> getAllLanguages();
}
