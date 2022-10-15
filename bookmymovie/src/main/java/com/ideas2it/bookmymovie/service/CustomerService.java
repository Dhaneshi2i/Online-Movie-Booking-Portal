package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookingDto;

public interface CustomerService {
    BookingDto createBooking(BookingDto bookingDto);
}
