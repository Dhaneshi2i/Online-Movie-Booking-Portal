package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookingSlimDto {
    private int bookingId;
    private LocalDate bookingDate;
    private MovieSlimDto movieSlimDto;
    private List<SeatSlimDto> seats;
    private double totalCost;
}
