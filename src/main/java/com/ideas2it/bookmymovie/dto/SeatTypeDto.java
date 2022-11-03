package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

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

    @NotBlank(message = "Seat type should not be empty")
    private String seatType;

    @NotNull(message = "Number of columns should not be empty")
    @Range(min=5,max=50)
    private int noOfColumns;

    @NotNull(message = "Number of rows should not be empty")
    @Range(min=5,max=50)
    private int noOfRows;

    @NotNull(message = "Price should not be empty")
    private float price;
}
