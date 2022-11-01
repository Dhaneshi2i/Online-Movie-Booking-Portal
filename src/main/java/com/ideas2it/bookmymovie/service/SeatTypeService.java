package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatTypeDto;
import com.ideas2it.bookmymovie.model.SeatType;

import java.util.List;

public interface SeatTypeService {
    SeatTypeDto addSeatType(SeatTypeDto seatTypeDto);
    SeatType getSeatTypeBySeatTypeId(int seatTypeId);
}
