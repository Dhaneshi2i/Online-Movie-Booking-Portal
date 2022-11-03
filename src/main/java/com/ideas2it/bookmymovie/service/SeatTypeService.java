package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatTypeDto;
import com.ideas2it.bookmymovie.model.SeatType;

public interface SeatTypeService {

    SeatType getSeatTypeBySeatTypeId(int seatTypeId);

    SeatTypeDto addSeatType(SeatTypeDto seatTypeDto);
}
