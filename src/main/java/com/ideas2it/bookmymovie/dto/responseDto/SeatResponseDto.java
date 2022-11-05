package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;


/**
 * <p>
 * Seat Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/

@Getter
@Setter
public class SeatResponseDto {

    private int id;

    private String seatNumber;

    private SeatTypeResponseDto seatType;

    private float seatPrice;

}
