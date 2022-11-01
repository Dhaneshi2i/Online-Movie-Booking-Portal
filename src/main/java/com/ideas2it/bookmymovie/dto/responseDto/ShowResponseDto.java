package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class ShowResponseDto {

    private LocalTime showStartTime;
    private LocalTime showEndTime;
    private LocalDate showDate;
    private MovieResponseDto movie;
    private TheatreResponseDto theatre;
    private ScreenResponseDto screen;
}