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

    public LanguageServiceImpl(LanguageRepository languageRepository, MapStructMapper mapper) {
        this.languageRepository = languageRepository;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param languageDto it contains language dto objects.
     * @return LanguageDto
     */
    @Override
    public LanguageDto addLanguage(LanguageDto languageDto) {
        return mapper.languageToLanguageDto(languageRepository.save(mapper.languageDtoToLanguage(languageDto)));
    }

    /**
     * <p>
     * This method gets the language Details which matches the id
     * </p>
     *
     * @param languageId it contains language id
     * @return LanguageDto
     */
    @Override
    public LanguageDto getByLanguageId(int languageId) {
        return languageRepository.findByLanguageId(languageId)
                .map(language -> mapper.languageToLanguageDto(language))
                .orElseThrow(() ->new NotFoundException("No language found by name:" + languageId));
    }
}
