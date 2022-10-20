package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Seat;

import java.util.List;

public interface SeatService {
    public SeatDto createSeat(SeatDto seat) throws NotFoundException;

    public List<SeatDto> getAllSeat() throws NotFoundException;

    public SeatDto updateSeatById(int seatId) throws NotFoundException;

    public Seat bookSeat(Seat seat);

    public Seat cancelSeatBooking(Seat seat);

//    public SeatDto blockSeat(SeatDto seat); // not available for any booking

}
