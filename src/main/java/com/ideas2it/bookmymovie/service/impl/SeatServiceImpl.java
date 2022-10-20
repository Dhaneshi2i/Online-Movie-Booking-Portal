package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.repository.SeatRepository;
import com.ideas2it.bookmymovie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final MapStructMapper mapper;

    public SeatServiceImpl(SeatRepository seatRepository, MapStructMapper mapper) {
        this.seatRepository = seatRepository;
        this.mapper = mapper;
    }

    @Override
    public SeatDto addSeat(SeatDto seatDto) throws NotFoundException {
        Seat seat = mapper.seatDtoToSeat(seatDto);
        if (seatDto != null) {
            if (seatRepository.existsById(seat.getSeatId())) {
                throw new NotFoundException("Seat with this id already exists");
            } else {
                seatRepository.saveAndFlush(seat);
            }
        }
        return mapper.seatToSeatDto(seatRepository.findById(seat.getSeatId()).get());
    }

    @Override
    public List<SeatDto> viewSeatList() throws NotFoundException {
        List<Seat> seats = seatRepository.findAll();

        if (seats.size() == 0) throw new NotFoundException("No seats found");

        return mapper.seatListToSeatDtoList(seats);
    }

    @Override
    public SeatDto updateSeat(int seatId) throws NotFoundException{
        Optional<Seat> seat = seatRepository.findById(seatId);
        if(seat.isPresent()) {
            seat.get().setStatus(false);
            return mapper.seatToSeatDto(seatRepository.save(seat.get()));
        }
        throw new NotFoundException("Seat with the given id is not present");
    }

    @Override
    public SeatDto bookSeat(SeatDto seatDto) {
        Seat seat = mapper.seatDtoToSeat(seatDto);
        seat.setSeatStatus(SeatStatus.BOOKED);
        return mapper.seatToSeatDto(seatRepository.save(seat));
    }

    @Override
    public SeatDto cancelSeatBooking(SeatDto seatDto) {
        Seat seat = mapper.seatDtoToSeat(seatDto);
        seat.setSeatStatus(SeatStatus.CANCELLED);
        return mapper.seatToSeatDto(seatRepository.save(seat));
    }

    @Override
    public SeatDto blockSeat(SeatDto seatDto) {
        Seat seat = mapper.seatDtoToSeat(seatDto);
        seatDto.setSeatStatus(SeatStatus.BLOCKED);
        return mapper.seatToSeatDto(seatRepository.save(seat));
    }
}
