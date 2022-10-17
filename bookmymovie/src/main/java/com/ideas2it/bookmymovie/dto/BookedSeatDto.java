package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Component
public class BookedSeatDto {
    private int bookedSeatId;

    private SeatDto seat;

    private BookingDto booking;

    private ScreeningDto screening;
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private boolean status;
}

