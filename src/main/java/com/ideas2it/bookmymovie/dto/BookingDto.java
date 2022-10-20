package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.slimdto.ShowSlimDto;
import com.ideas2it.bookmymovie.slimdto.TicketSlimDto;
import com.ideas2it.bookmymovie.slimdto.UserSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingDto {
    private int transactionId;
    private ShowSlimDto show;
    private LocalDate bookingDate;
    private String transactionMode;
    private boolean transactionStatus;
    private double totalCost;
    private UserSlimDto user;
    private TicketSlimDto ticket;

}
