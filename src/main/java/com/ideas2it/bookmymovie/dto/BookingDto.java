package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {
    private int bookingId;
    @NotBlank
    private UserDto user;
    @NotBlank
    private ShowDto show;
    private LocalDate bookingDate;
    @NotBlank
    private String bookingStatus;
    @NotEmpty
    private List<SeatDto> seats;
    private double totalCost;
}
