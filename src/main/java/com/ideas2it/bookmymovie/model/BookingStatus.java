package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This BookingStatus Enum contains constant Booking status that are available
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@AllArgsConstructor
public enum BookingStatus {
    ONPROCESS("OnProcess"), COMPLETED("Completed"), CANCELLED("Cancelled");

    @Setter
    @Getter
    private String status;
}
