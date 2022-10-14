package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookedSeatDto {
    private int bookedSeatId;
    private SeatDto seat;
    private BookingDto booking;
    private ScreeningDto screening;
}

