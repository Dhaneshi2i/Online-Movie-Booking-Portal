package com.ideas2it.bookmymovie.service;

import java.util.List;

public interface SeatService {
    public void createSeat(SeatDto seatDto);
    public List<SeatDto> getAllSeats();
    public void cancelSeat(SeatDto seatDto, int id);
    public void deleteSeat(int id);
}
