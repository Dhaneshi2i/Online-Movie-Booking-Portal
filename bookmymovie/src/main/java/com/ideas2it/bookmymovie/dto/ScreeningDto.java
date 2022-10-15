package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ScreeningDto {
    private int ScreeningId;
    private MovieDto movie;
    private LocalDate showDate;
    private LocalTime startTime;
    private List<BookedSeatDto> bookedSeats = new ArrayList<>();
    private List<BookingDto> bookings = new ArrayList<>();
    private ScreenDto screen;
}
