package com.ideas2it.bookmymovie.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Booking} entity
 */
@Data
public class BookingDto{
    private int id;
    private List<String> seatNo;
    private LocalDate booking_date;
    private UsersDto usersDto;
    private ScreeningDto screeningDto;
    private List<BookedSeatDto> bookedSeatsDto = new ArrayList<>();
}