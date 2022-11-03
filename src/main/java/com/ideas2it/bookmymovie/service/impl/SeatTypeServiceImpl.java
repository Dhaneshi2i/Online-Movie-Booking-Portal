package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatTypeDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.repository.SeatTypeRepository;
import com.ideas2it.bookmymovie.service.SeatTypeService;
import org.springframework.stereotype.Service;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {
    private final SeatTypeRepository seatTypeRepository;
    private final MapStructMapper mapper;

    public SeatTypeServiceImpl(SeatTypeRepository seatTypeRepository, MapStructMapper mapper) {
        this.seatTypeRepository = seatTypeRepository;
        this.mapper = mapper;
    }

    @Override
    public SeatType getSeatTypeBySeatTypeId(int seatTypeId) {
         return seatTypeRepository.findBySeatTypeId(seatTypeId);
    }

    @Override
    public SeatTypeDto addSeatType(SeatTypeDto seatTypeDto) {
        return mapper.seatTypeToSeatTypeDto(seatTypeRepository.save(mapper.seatTypeDtoToSeatType(seatTypeDto)));
    }

}
