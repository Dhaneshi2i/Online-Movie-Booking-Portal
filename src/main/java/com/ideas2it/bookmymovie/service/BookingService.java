package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookingDto;

import java.util.List;

public interface  BookingService {
    BookingDto createBooking(BookingDto bookMovie);

    List<BookingDto> getAllBookings();

    //BookingDto updateBookings(BookingDto bookingDto);

    BookingDto viewByBookingId(int bookingId);

    BookingDto cancelBooking(int bookingId);

//    List<BookingDto> getAllBookingsByMovieId(int movieId);

//    double calculateTotalCost(int bookingId);
}
