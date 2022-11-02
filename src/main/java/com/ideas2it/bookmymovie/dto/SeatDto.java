package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * Seat Dto class contains the seat dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class SeatDto {

    private int id;
    @NotBlank
    private String seatNumber;
    private SeatTypeDto seatType;
    @NotNull
    private float seatPrice;

}

