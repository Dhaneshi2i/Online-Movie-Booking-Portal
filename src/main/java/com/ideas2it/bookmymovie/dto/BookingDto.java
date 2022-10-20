package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingDto {

    private int bookingId;
    @NotNull
    private UserDto user;
    @NotNull
    private ShowDto show;
    @NotNull
    private String bookingStatus;
    @NotNull
    private List<SeatDto> seats;

    //private int noOfSeats;

    //private LocalDate bookingDate;

    //private String transactionMode;

    //private String transactionStatus;

    //private double totalCost;

    //private TicketDto ticket;
}
