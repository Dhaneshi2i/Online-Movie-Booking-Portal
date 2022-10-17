package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class SeatDto {
    private int seatId;
    private int seatNo;
    private String seatType;
    private ScreenDto screen;
    private List<BookedSeatDto> bookedSeats = new ArrayList<>();
}

