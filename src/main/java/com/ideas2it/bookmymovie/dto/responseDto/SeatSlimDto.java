package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.model.SeatStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SeatSlimDto {
    private int seatId;

    private String seatNumber;

    private String type;

    private double price;

    private SeatStatus seatStatus;
}
