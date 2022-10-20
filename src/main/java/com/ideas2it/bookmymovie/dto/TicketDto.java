package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.slimdto.SeatSlimDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TicketDto {
    private int ticketId;
    private int noOfSeats;
    private boolean ticketStatus;
    private List<SeatSlimDto> seats;
    //private BookingSlimDto booking;
}
