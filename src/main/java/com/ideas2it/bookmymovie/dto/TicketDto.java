package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TicketDto {
    private int ticketId;
    private int noOfSeats;
    private boolean ticketStatus;
    private List<SeatDto> seats;
    private BookingDto booking;
}
