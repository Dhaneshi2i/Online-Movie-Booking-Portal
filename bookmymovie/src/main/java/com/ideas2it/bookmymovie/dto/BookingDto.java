package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Booking} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingDto{
    private int id;
    private List<String> seatNo;
    private LocalDate bookingDate;
    private UsersDto users;
    private ScreeningDto screening;
    private LocalDate booking_date;
    private List<BookedSeatDto> bookedSeats = new ArrayList<>();
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private boolean status;
}

