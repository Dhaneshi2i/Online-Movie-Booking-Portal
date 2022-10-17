package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "screenId")

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screen} entity
 */
public class ScreenDto {
    private int screenId;
    private int noOfSeats;
    private int noOfRows;
    private int noOfColumns;
    private TheatreDto theatreDto;
    private List<SeatDto> seats = new ArrayList<>();
    private List<ScreeningDto> screenings = new ArrayList<>();
}
