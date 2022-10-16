package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Cast;
import com.ideas2it.bookmymovie.repository.CastRepository;
import com.ideas2it.bookmymovie.service.CastService;
import org.modelmapper.ModelMapper;

public class CastServiceImpl implements CastService {
    public ModelMapper mapper;
    public CastRepository castRepository;
    public Cast cast;

    public CastServiceImpl(ModelMapper mapper, CastRepository castRepository, Cast cast) {
        this.mapper = mapper;
        this.castRepository = castRepository;
        this.cast = cast;
    }

    @Override
    public CastDto addCast(CastDto castDto) {
        return mapper.map(castRepository.save(mapper.map(castDto, Cast.class)), CastDto.class);
    }

    @Override
    public CastDto getCastByName(String name) throws NotFoundException {
        cast = castRepository.findCastByName(name);
        if (null == cast) {
            throw new NotFoundException("No cast found");
        }
        return mapper.map(cast, CastDto.class);
    }
}
