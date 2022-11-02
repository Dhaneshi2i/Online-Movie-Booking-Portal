package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * Seat type  Dto class contains the seat type dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class SeatTypeDto {

    private int id;
    @NotBlank
    private String seatType;
    @NotNull
    private int noOfColumns;
    @NotNull
    private int noOfRows;
    @NotNull
    private float price;
}
