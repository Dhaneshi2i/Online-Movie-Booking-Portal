package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ShowSlimDto {
    @NotNull
    private LocalTime showStartTime;
    @NotNull
    private LocalTime showEndTime;
    @NotNull
    private LocalDate showDate;
    private MovieSlimDto movie;
    private TheatreSlimDto theatre;
    private ScreenSlimDto screen;
}
