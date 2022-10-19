package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.SeatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SeatDto {

    private int seatId;

    private String seatNumber;

    private String type;

    private double price;

    private SeatTypeEnum seatStatus;

    private TicketDto ticket;
}

