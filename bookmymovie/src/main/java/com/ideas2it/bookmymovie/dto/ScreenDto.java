package com.ideas2it.bookmymovie.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screen} entity
 */
@Data
public class ScreenDto {
    private int screenId;
    private int noOfSeats;
    private int noOfRows;
    private int noOfColumns;
    private TheatreDto theatreDto;
    private List<SeatDto> seatsDto = new ArrayList<>();
    private List<ScreeningDto> screeningsDto = new ArrayList<>();
}