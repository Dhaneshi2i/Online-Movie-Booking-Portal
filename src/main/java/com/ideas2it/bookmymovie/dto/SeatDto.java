package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private double price;

    //private SeatStatus seatStatus;

    //private TicketSlimDto ticket;
}

