package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.repository.SeatTypeRepository;
import com.ideas2it.bookmymovie.service.SeatTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {
    private SeatTypeRepository seatTypeRepository;

    public SeatTypeServiceImpl(SeatTypeRepository seatTypeRepository) {
        this.seatTypeRepository = seatTypeRepository;
    }


    public SeatType addSeatType(SeatType seatType){
        return seatTypeRepository.save(seatType);

    }

    public List<SeatType> getAll() {
        return seatTypeRepository.findAll();
    }
}
