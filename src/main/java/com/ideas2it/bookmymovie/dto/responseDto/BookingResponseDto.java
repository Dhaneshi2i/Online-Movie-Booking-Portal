package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.dto.ShowDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookingResponseDto {

    private int bookingId;
    private UserSlimDto user;
    private ShowSlimDto show;
    private LocalDate bookingDate;
    private List<SeatSlimDto> seats;
    private double totalCost;
}
