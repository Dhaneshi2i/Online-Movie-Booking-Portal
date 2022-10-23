package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum BookingStatus {
    ONPROCESS("On_process"), COMPLETED("Completed"), CANCELLED("Cancelled");

    @Setter
    @Getter
    private String status;
}
