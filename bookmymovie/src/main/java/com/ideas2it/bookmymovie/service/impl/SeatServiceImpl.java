package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.repository.SeatRepository;
import com.ideas2it.bookmymovie.service.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {
    public final ModelMapper mapper;
    public final SeatRepository seatRepository;
    public Seat seat;

    public SeatServiceImpl(ModelMapper mapper, SeatRepository seatRepository, Seat seat) {
        this.mapper = mapper;
        this.seatRepository = seatRepository;
        this.seat = seat;
    }


    @Override
    public SeatDto createSeat(SeatDto seatDto) {
        return mapper.map(seatRepository.save(mapper.map(seatDto, Seat.class)), SeatDto.class);
    }

    @Override
    public List<SeatDto> getAllSeats() {
        return null;
    }

    @Override
    public SeatDto getSeatById(int id) throws NotFoundException {
        seat = seatRepository.findById(id);
        if (null == seat) {
            throw new NotFoundException("No seat found");
        }
        return mapper.map(seat, SeatDto.class);
    }

    @Override
    public SeatDto cancelSeat(SeatDto seatDto) {
        return null;
    }

}
