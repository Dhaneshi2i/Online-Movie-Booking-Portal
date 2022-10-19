package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.repository.LanguageRepository;
import com.ideas2it.bookmymovie.service.LanguageService;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {
    private LanguageRepository languageRepository;
    private MapStructMapper mapper;
    @Override
    public LanguageDto addLanguage(LanguageDto languageDto) {
        return mapper.languageToLanguageDto(languageRepository.save(mapper.languageDtoToLanguage(languageDto)));
    }

    @Override
    public LanguageDto getLanguageByName(String name) {
        return languageRepository.findLanguageByName(name).map(language -> mapper.languageToLanguageDto(language))
                .orElseThrow(() ->new NotFoundException("No language found by name:" + name));
    }
}