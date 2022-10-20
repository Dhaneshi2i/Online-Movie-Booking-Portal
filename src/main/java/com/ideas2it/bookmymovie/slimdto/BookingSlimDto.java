package com.ideas2it.bookmymovie.slimdto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BookingSlimDto {
    private int transactionId;
    private ShowSlimDto show;
    private LocalDate bookingDate;
    private String transactionMode;
    private boolean transactionStatus;
    private double totalCost;
}
