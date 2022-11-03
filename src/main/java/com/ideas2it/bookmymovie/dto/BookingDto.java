package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Booking Dto class contains the booking dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class BookingDto {

    @NotBlank(message = "Transaction mode should not be empty")
    @Pattern(regexp="^(Online|Offline)$",message="Invalid transaction status . Valid values are 1. ONLINE 2. OFFLINE")
    private String transactionMode;

    private UserDto user;

    private ShowDto show;

    private LocalDate bookingDate;

    @NotEmpty(message = "Seat should not be empty")
    private List<SeatDto> seats;

    private float totalCost;
}
