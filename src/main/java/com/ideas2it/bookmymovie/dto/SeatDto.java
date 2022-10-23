package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private int seatId;
    @NotBlank
    private String seatNumber;
    @NotBlank
    private String type;
    @NotBlank
    private double price;

    //private SeatStatus seatStatus;

    //private TicketSlimDto ticket;
}

