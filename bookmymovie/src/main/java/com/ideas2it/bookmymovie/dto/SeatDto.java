package com.ideas2it.bookmymovie.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;


/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Seat} entity
 */
@Data
public class SeatDto {
    private int seatId;
    private int seatNo;
    private ScreenDto screenDto;
    private List<BookedSeatDto> bookedSeatsDto = new ArrayList<>();
}