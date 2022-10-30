package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public enum SeatType {
    BALCONY("Balcony"),GOLD("Gold"),SILVER("Silver"),PLATINUM("Platinum");
    @Getter
    @Setter
    private String seatType;
}
