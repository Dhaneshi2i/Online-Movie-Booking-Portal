package com.ideas2it.bookmymovie.slimdto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ShowSlimDto {
    private int showId;
    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;
    private LocalDate showDate;
}
