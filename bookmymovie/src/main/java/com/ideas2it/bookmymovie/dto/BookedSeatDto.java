package com.ideas2it.bookmymovie.dto;

import lombok.Data;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.BookedSeat} entity
 */
@Data
public class BookedSeatDto {
    private int bookedSeatId;
    private SeatDto seatDto;
    private BookingDto bookingDto;
    private ScreeningDto screeningDto;
}