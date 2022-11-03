package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.model.SeatStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    private String seatNumber;

    private SeatTypeResponseDto seatType;

    private float seatPrice;

    private SeatStatus seatStatus;
}
