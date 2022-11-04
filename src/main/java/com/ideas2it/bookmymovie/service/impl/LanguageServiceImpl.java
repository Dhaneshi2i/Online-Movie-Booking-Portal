package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.exception.AlreadyExistException;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Language;
import com.ideas2it.bookmymovie.repository.LanguageRepository;
import com.ideas2it.bookmymovie.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * This {@Code LanguageService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final MapStructMapper mapper;

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
        Language language = mapper.languageDtoToLanguage(languageDto);
        if (languageRepository.existsByLanguageName(languageDto.getLanguageName())) {
            throw new AlreadyExistException("This language already exists, please provide a different language");
        }
        return mapper.languageToLanguageDto(languageRepository.save(language));
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
                .map(mapper::languageToLanguageDto)
                .orElseThrow(() ->new NotFoundException("No language found by name:" + languageId));
    }

    /**
     * <p>
     * This method returns list of all languages
     * </p>
     * @return List<LanguageDto>
     */
    @Override
    public List<LanguageDto> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();
        if (languages.isEmpty()) {
            throw new NotFoundException("No language details is available");
        }
        return mapper.languageListToLanguageDtoList(languages);
    }
}
