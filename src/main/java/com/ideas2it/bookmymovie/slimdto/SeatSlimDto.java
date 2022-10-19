package com.ideas2it.bookmymovie.slimdto;

import com.ideas2it.bookmymovie.model.SeatTypeEnum;
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

    private SeatTypeEnum seatStatus;
}
