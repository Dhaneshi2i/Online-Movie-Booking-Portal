package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatTypeDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.repository.SeatTypeRepository;
import com.ideas2it.bookmymovie.service.SeatTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * This {@Code SeatTypeService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Service
public class SeatTypeServiceImpl implements SeatTypeService {
    private final SeatTypeRepository seatTypeRepository;
    private final MapStructMapper mapper;

    public SeatTypeServiceImpl(SeatTypeRepository seatTypeRepository, MapStructMapper mapper) {
        this.seatTypeRepository = seatTypeRepository;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create the SeatType details
     * </p>
     *
     * @param seatTypeDto it contains seatType Dto object
     * @return SeatTypeDto
     */
    @Override
    public SeatTypeDto addSeatType(SeatTypeDto seatTypeDto) {
        return mapper.seatTypeToSeatTypeDto(seatTypeRepository.save(mapper.seatTypeDtoToSeatType(seatTypeDto)));
    }

}
