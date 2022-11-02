package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Booking Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
public class BookingResponseDto {

    private int bookingId;
    private UserResponseDto user;
    private ShowResponseDto show;
    private String transactionMode;
    private LocalDate bookingDate;
    private List<SeatResponseDto> seats;
    private double totalCost;
}
