package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private int seatId;
    private int seatNo;
    private ScreenDto screen;
    private List<BookedSeatDto> bookedSeats = new ArrayList<>();
}
