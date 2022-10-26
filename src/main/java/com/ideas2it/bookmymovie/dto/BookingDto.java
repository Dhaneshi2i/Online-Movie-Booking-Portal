package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ideas2it.bookmymovie.dto.responseDto.ShowSlimDto;
import com.ideas2it.bookmymovie.dto.responseDto.UserSlimDto;
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
    private UserSlimDto user;
    @NotBlank
    private ShowSlimDto show;
    @NotBlank
    private String bookingStatus;
    @NotEmpty
    private List<SeatDto> seats;

    //private int noOfSeats;

    private LocalDate bookingDate;

    //private String transactionMode;

    //private String transactionStatus;

    private double totalCost;

}
