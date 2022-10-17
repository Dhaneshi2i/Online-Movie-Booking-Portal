package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Cast;
import com.ideas2it.bookmymovie.repository.CastRepository;
import com.ideas2it.bookmymovie.service.CastService;

public class CastServiceImpl implements CastService {
    public MapStructMapper mapper;
    public CastRepository castRepository;
    public Cast cast;

    public CastServiceImpl(MapStructMapper mapper, CastRepository castRepository, Cast cast) {
        this.mapper = mapper;
        this.castRepository = castRepository;
        this.cast = cast;
    }

    @Override
    public CastDto addCast(CastDto castDto) {
        return mapper.castToCastDto(castRepository.save(mapper.castDtoToCast(castDto)));
    }

    @Override
    public CastDto getCastByName(String name) throws NotFoundException {
        cast = castRepository.findCastByName(name);
        if (null == cast) {
            throw new NotFoundException("No cast found");
        }
        return mapper.castToCastDto(cast);
    }
}
