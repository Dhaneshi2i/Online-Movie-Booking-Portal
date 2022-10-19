package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingDto {
    private int transactionId;
    private ShowDto show;
    private LocalDate bookingDate;
    private String transactionMode;
    private String transactionStatus;
    private double totalCost;
    private UserDto user;
    private TicketDto ticket;

}
