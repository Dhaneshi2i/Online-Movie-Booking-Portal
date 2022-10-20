package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface SeatService {
    public SeatDto addSeat(SeatDto seat) throws NotFoundException;

    public List<SeatDto> viewSeatList() throws NotFoundException;

    public SeatDto updateSeat(int seatId) throws NotFoundException;

    public SeatDto bookSeat(SeatDto seat);

    public SeatDto cancelSeatBooking(SeatDto seat);

    public SeatDto blockSeat(SeatDto seat); // not available for any booking
}
