package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.exception.AlreadyExistException;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Cast;
import com.ideas2it.bookmymovie.repository.CastRepository;
import com.ideas2it.bookmymovie.service.CastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastServiceImpl implements CastService {
    private final CastRepository castRepository;
    private final MapStructMapper mapper;

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
    public CastDto addCast(CastDto castDto) {
        Cast cast = mapper.castDtoToCast(castDto);
        if (castRepository.existsByCastName(castDto.getCastName()) && castRepository.existsByCastRole(castDto.getCastRole())) {
            throw new AlreadyExistException("This cast Name already exists, please provide a different cast");
        }
        return mapper.castToCastDto(castRepository.save(cast));
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
        return castRepository.findById(castId).map(mapper::castToCastDto)
                .orElseThrow(() -> new NotFoundException("No cast found"));
    }

    @Override
    public List<CastDto> getAllCasts() {
        List<Cast> casts = castRepository.findAll();
        if (casts.isEmpty()) {
            throw new NotFoundException("No cast details available");
        }
        return mapper.castListToCastDtoList(casts);
    }
}
