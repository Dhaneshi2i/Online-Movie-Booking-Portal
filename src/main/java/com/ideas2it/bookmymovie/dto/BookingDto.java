package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private BigDecimal transactionId;
    private ShowDto show;
    private LocalDate bookingDate;
    private String transactionMode;
    private String transactionStatus;
    private double totalCost;
    private CustomerDto customer;
    private TicketDto ticket;

}
