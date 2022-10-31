package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.responseDto.CastResponseDto;
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

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param castDto it contains cast dto objects
     * @return CastResponseDto
     */
    @Override
    public CastResponseDto addCast(CastDto castDto) {
        return mapper.castToCastResponseDto(castRepository.save(mapper.castDtoToCast(castDto)));
    }

    /**
     * <p>
     * This method gets castId as parameter and get the Cast Details which matches the id
     * </p>
     *
     * @param castId it contains cast id
     * @return CastDto
     */
    @Override
    public CastDto getByCastId(int castId) {
        return castRepository.findById(castId).map(cast -> mapper.castToCastDto(cast)).orElseThrow(() -> new NotFoundException("No cast found"));
    }
}
