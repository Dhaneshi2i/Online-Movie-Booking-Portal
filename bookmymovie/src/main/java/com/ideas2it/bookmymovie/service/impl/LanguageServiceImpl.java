package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.model.Language;
import com.ideas2it.bookmymovie.repository.LanguageRepository;
import com.ideas2it.bookmymovie.service.LanguageService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final ModelMapper mapper;
    public LanguageDto getLanguageByName(String name) {
        Language language = languageRepository.findLanguageByName(name);

        return mapper.map(language, LanguageDto.class);
    }
}
