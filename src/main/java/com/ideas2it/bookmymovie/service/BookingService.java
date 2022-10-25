package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Seat;

import java.util.List;

public interface  BookingService {
    BookingDto createBooking(BookingDto bookMovie, int userId, int showId);

    List<BookingDto> getAllBookings();

    BookingDto viewByBookingId(int bookingId);

    BookingDto cancelBooking(int bookingId);
    double calculateTotalCost(List<Seat> seats);

    Booking cancelSeatBooking(int bookingId, int seatId);
}
