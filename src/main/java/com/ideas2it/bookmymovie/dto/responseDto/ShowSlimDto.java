package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ShowSlimDto {
    private LocalTime showStartTime;
    private LocalTime showEndTime;
    private LocalDate showDate;
    private MovieSlimDto movie;
    private ScreenSlimDto screen;
    private TheatreSlimDto theatre;
}
