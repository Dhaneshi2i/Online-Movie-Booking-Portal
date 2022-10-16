package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreeningDto;
import com.ideas2it.bookmymovie.model.Screening;
import com.ideas2it.bookmymovie.repository.ScreeningRepository;
import com.ideas2it.bookmymovie.service.ScreeningService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    public ModelMapper mapper;
    public ScreeningRepository screeningRepository;

    public ScreeningServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ScreeningDto addScreening(ScreeningDto screeningDto) {
        return mapper.map(screeningRepository.save(mapper.map(screeningDto, Screening.class)), ScreeningDto.class);
    }
}
