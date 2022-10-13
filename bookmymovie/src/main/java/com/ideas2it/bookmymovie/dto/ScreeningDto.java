package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Movie;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screening} entity
 */
@Data
public class ScreeningDto {
    private int ScreeningId;
    private MovieDto moviedto;
    private LocalDate showDate;
    private LocalTime startTime;
    private List<BookedSeatDto> bookedSeatsDto = new ArrayList<>();
    private List<BookingDto> bookingsDto = new ArrayList<>();
    private ScreenDto screenDto;
}