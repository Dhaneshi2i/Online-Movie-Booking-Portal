package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Language;
import com.ideas2it.bookmymovie.repository.LanguageRepository;
import com.ideas2it.bookmymovie.service.LanguageService;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final MapStructMapper mapper;

    public LanguageServiceImpl(LanguageRepository languageRepository, MapStructMapper mapper) {
        this.languageRepository = languageRepository;
        this.mapper = mapper;
    }

    public LanguageDto getLanguageByName(String name) {
        Language language = languageRepository.findLanguageByName(name);

        return mapper.languageToLanguageDto(language);
    }

    @Override
    public LanguageDto addLanguage(LanguageDto languageDto) {
        return mapper.languageToLanguageDto(languageRepository.save(mapper.languageDtoToLanguage(languageDto)));
    }
}
