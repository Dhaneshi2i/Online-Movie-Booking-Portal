package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowDto {
    private BigDecimal showId;
    private LocalTime showStartTime;
    private LocalTime showEndTime;
    private TheatreDto theatre;
    private BookingDto booking;
    private LocalDate showDate;
}
