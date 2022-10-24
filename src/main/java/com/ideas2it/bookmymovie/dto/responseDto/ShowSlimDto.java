package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ShowSlimDto {
    private int showId;
    private LocalTime showStartTime;
    private LocalTime showEndTime;
    private LocalDate showDate;
    private MovieSlimDto movie;
}
