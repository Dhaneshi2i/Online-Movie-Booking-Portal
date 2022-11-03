package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.model.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
/**
 * <p>
 * Booking Cancelled Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
public class BookingCancelledResponseDto {

    private UserResponseDto user;

    private String transactionMode;

    private LocalDate bookingDate;

    private BookingStatus bookingStatus;

    private double totalCost;
}
