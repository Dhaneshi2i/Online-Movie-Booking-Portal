package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.model.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatSlimDto {
    private int seatId;

    private String seatNumber;

    private String type;

    private double price;

    private SeatStatus seatStatus;
}
