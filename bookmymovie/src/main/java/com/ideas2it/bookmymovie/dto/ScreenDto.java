package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screen} entity
 */
public class ScreenDto {
    private int screenId;
    private int noOfSeats;
    private int noOfRows;
    private int noOfColumns;
    @JsonBackReference
    private TheatreDto theatre;
    @JsonManagedReference
    private List<SeatDto> seats = new ArrayList<>();
    @JsonManagedReference
    private List<ScreeningDto> screenings = new ArrayList<>();
}
