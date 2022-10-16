package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface SeatService {
    SeatDto createSeat(SeatDto seatDto);
    List<SeatDto> getAllSeats();
    SeatDto getSeatById(int id) throws NotFoundException;
    SeatDto cancelSeat(SeatDto seatDto);
}
