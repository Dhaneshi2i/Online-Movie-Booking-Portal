package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SeatDto {
    private int seatId;
    private int seatNo;
    private String seatType;
    @JsonBackReference
    private ScreenDto screen;
    @JsonManagedReference
    private List<BookedSeatDto> bookedSeats = new ArrayList<>();
}

