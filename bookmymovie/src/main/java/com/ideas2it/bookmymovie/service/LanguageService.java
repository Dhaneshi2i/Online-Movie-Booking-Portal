package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;

public interface LanguageService {
    LanguageDto getLanguageByName(String name);
}
