package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    @NotBlank
    private String transactionMode;
    private UserDto user;
    private ShowDto show;
    private LocalDate bookingDate;
    @NotEmpty
    private List<SeatDto> seats;
    @NotNull
    private float totalCost;
}
