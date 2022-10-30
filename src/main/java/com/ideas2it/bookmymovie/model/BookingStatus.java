package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum BookingStatus {
    ONPROCESS("OnProcess"), COMPLETED("Completed"), CANCELLED("Cancelled");

    @Setter
    @Getter
    private String status;
}
