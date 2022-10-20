package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public enum SeatStatus {
    AVAILABLE("Available"), BLOCKED("Blocked"), BOOKED("Booked"), CANCELLED("Cancelled");

    @Setter
    @Getter
    private String status;

}
