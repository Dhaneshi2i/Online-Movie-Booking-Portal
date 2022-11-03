package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * <p>
 * Show Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
public class ShowResponseDto {

    private int id;

    private LocalDate showDate;

    private LocalTime showStartTime;

    private MovieResponseDto movie;

    private ScreenResponseDto screen;
}
