package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BookingDto{
    private int id;
    private List<String> seatNo;
    private LocalDate booking_date;
    private UsersDto usersDto;
    private ScreeningDto screeningDto;
    private List<BookedSeatDto> bookedSeatsDto = new ArrayList<>();
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private boolean status;
}

