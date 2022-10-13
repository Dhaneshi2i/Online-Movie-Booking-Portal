package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookedSeatDto;
import com.ideas2it.bookmymovie.dto.BookingDto;

import java.util.List;

public interface BookedSeatService {
    void createBookedSeat(BookedSeatDto bookedSeatDto);
    List<BookingDto> getAllBookedSeats();
    BookedSeatDto getBookedSeatById(int id);
    BookedSeatDto updateBookedSeat(BookedSeatDto bookedSeatDto, int id);
    void cancelBookedSeatById(int id);
}
