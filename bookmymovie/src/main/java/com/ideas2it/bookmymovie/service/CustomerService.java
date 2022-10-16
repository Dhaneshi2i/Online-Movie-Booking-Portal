package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface CustomerService {
    BookingDto createBooking(BookingDto bookingDto);
    List<BookingDto> getAllBookings() throws NotFoundException;
    BookingDto getBookingById(int id) throws NotFoundException;
}
