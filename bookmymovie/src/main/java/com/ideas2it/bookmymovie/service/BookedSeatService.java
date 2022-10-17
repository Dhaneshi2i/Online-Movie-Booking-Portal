package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookedSeatDto;
import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface BookedSeatService {
    void createBookedSeat(BookedSeatDto bookedSeatDto);
    List<BookedSeatDto> getAllBookedSeats() throws NotFoundException;
    BookedSeatDto getBookedSeatById(int id) throws NotFoundException;
    BookedSeatDto updateBookedSeat(int id, boolean status);
    void cancelBookedSeatById(int id, boolean status);
}
