package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.repository.SeatRepository;
import com.ideas2it.bookmymovie.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {
    public final MapStructMapper mapper;
    public final SeatRepository seatRepository;
    public Seat seat;

    public SeatServiceImpl(MapStructMapper mapper, SeatRepository seatRepository, Seat seat) {
        this.mapper = mapper;
        this.seatRepository = seatRepository;
        this.seat = seat;
    }

    @Override
    public SeatDto createSeat(SeatDto seatDto) {
        return mapper.seatToSeatDto(seatRepository.save(mapper.seatDtoToSeat(seatDto)));
    }

    @Override
    public List<SeatDto> getAllSeats() {
        return null;
    }

    @Override
    public SeatDto getSeatById(int id) throws NotFoundException {
        return seatRepository.findById(id).map(mapper::seatToSeatDto).orElseThrow(() -> new NotFoundException("No seat found"));
    }

    @Override
    public SeatDto cancelSeat(SeatDto seatDto) {
        return null;
    }

}
