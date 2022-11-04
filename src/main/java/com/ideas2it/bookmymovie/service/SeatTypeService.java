package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatTypeDto;
import com.ideas2it.bookmymovie.model.SeatType;

/**
 * <p>
 * This {@Code SeatTypeService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface SeatTypeService {

    /**
     * <p>
     * This method is used to create the SeatType details
     * </p>
     *
     * @param seatTypeDto it contains seatType Dto object
     * @return SeatTypeDto
     */
    SeatTypeDto addSeatType(SeatTypeDto seatTypeDto);
}
