package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This SeatType Enum contains constant seat types that are available
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@AllArgsConstructor
public enum SeatType {
    BALCONY("Balcony"),GOLD("Gold"),SILVER("Silver"),PLATINUM("Platinum");
    @Getter
    @Setter
    private String seatType;
}
