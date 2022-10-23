package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.LanguageDto;

public interface LanguageService {
    LanguageDto addLanguage(LanguageDto languageDto);
    LanguageDto getByLanguageId(int languageId);
}
