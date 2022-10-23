package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDto {
    private int transactionId;
    //private int noOfSeats;
    //private boolean transactionStatus;
    @NotBlank(message = "Please enter the mode of transaction")
    private String transactionMode;
    //private List<SeatSlimDto> seats;
    //private BookingSlimDto booking;
}
