package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This SeatStatus Enum contains constant seat status that are available
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@AllArgsConstructor
public enum SeatStatus {
    AVAILABLE("Available"), BLOCKED("Blocked"), BOOKED("Booked"), CANCELLED("Cancelled");

    @Setter
    @Getter
    private String status;

}
