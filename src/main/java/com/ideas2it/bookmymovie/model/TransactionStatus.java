package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum TransactionStatus {
    SUCCESSFUL("Successful"), ONPROCESS("Onprocess"), FAILED("Failed") , CANCELLED("Cancelled");

    @Getter
    @Setter
    private String status;
}
