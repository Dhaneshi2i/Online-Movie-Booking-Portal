package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedSeatDto {
    private int bookedSeatId;
    private SeatDto seat;
    private BookingDto booking;
    private ScreeningDto screening;
}
