package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.model.SeatType;

import java.util.List;

public interface SeatTypeService {
    SeatType addSeatType(SeatType seatType);
    List<SeatType> getAll();
}
