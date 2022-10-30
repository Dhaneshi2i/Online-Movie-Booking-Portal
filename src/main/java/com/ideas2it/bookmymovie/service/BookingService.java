package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingResponseDto;
import com.ideas2it.bookmymovie.model.Seat;

import java.util.List;

public interface  BookingService {
    BookingResponseDto createBooking(BookingDto bookMovie);
    List<BookingDto> getAllBookings();
    BookingDto viewByBookingId(int bookingId);
    BookingDto cancelBooking(int bookingId);
    double calculateTotalCost(List<Seat> seats);

    //Booking cancelSeatBooking(int bookingId, int seatId);
}
