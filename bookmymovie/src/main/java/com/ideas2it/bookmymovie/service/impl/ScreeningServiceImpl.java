package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreeningDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screening;
import com.ideas2it.bookmymovie.repository.ScreeningRepository;
import com.ideas2it.bookmymovie.service.ScreeningService;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    public MapStructMapper mapper;
    public ScreeningRepository screeningRepository;

    public ScreeningServiceImpl(MapStructMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ScreeningDto addScreening(ScreeningDto screeningDto) {
        return mapper.screeningToScreeningDto(screeningRepository.save(mapper.screeningDtoToScreening(screeningDto)));
    }
}
