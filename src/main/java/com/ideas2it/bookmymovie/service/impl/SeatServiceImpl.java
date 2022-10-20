package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.repository.SeatRepository;
import com.ideas2it.bookmymovie.service.SeatService;
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
    public SeatDto createSeat(SeatDto seatDto) throws NotFoundException {
        if (null != seatDto) {
            if (seatRepository.findBySeatNumberAndType(seatDto.getSeatNumber(),seatDto.getType())) {
                throw new NotFoundException("Seat number already exists");
            } else {
                seatRepository.saveAndFlush(mapper.seatDtoToSeat(seatDto));
            }
        }
        return seatDto;
    }

    @Override
    public List<SeatDto> getAllSeat() throws NotFoundException {
        List<Seat> seats = seatRepository.findBySeatStatus("Available");

        if (0 == seats.size()) throw new NotFoundException("No seats found");

        return mapper.seatListToSeatDtoList(seats);
    }

    @Override
    public SeatDto updateSeatById(int seatId) throws NotFoundException{
        Optional<Seat> seat = seatRepository.findById(seatId);
        if(seat.isPresent()) {
            seat.get().setStatus(false);
            return mapper.seatToSeatDto(seatRepository.save(seat.get()));
        }
        throw new NotFoundException("Seat with the given id is not present");
    }

    @Override
    public Seat bookSeat(Seat seat) {
        seat.setSeatStatus(SeatStatus.BOOKED);
        return seatRepository.save(seat);
    }

    @Override
    public Seat cancelSeatBooking(Seat seat) {
        seat.setSeatStatus(SeatStatus.AVAILABLE);
        return seatRepository.save(seat);
    }

//    @Override
//    public SeatDto blockSeat(SeatDto seatDto) {
//        Seat seat = mapper.seatDtoToSeat(seatDto);
//        seatDto.setSeatStatus(SeatStatus.BLOCKED);
//        return mapper.seatToSeatDto(seatRepository.save(seat));
//    }
}
