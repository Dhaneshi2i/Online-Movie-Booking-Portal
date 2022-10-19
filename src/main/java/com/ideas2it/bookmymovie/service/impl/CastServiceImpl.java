package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.repository.CastRepository;
import com.ideas2it.bookmymovie.service.CastService;
import org.springframework.stereotype.Service;

@Service
public class CastServiceImpl implements CastService {
    private CastRepository castRepository;
    private MapStructMapper mapper;

    public CastServiceImpl(CastRepository castRepository, MapStructMapper mapper) {
        this.castRepository = castRepository;
        this.mapper = mapper;
    }

    @Override
    public CastDto addCast(CastDto castDto) {
        return mapper.castToCastDto(castRepository.save(mapper.castDtoToCast(castDto)));
    }

    @Override
    public CastDto getCastByName(String name) {
        return castRepository.findCastByName(name).map(cast -> mapper.castToCastDto(cast)).orElseThrow(() -> new NotFoundException("No cast found"));
    }
}