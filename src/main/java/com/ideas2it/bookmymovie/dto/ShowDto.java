package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.dto.responseDto.MovieSlimDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenSlimDto;
import com.ideas2it.bookmymovie.dto.responseDto.TheatreSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowDto {
    private int showId;
    @NotNull
    private LocalDate showDate;
    @NotNull
    private LocalTime showStartTime;
    @NotNull
    private LocalTime showEndTime;

    private MovieSlimDto movie;

    private TheatreSlimDto theatre;

    private ScreenSlimDto screen;
    //private BookingDto booking;
}
