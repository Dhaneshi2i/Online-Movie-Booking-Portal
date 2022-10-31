package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingResponseDto;
import com.ideas2it.bookmymovie.model.Seat;

import java.util.List;

public interface  BookingService {

    /**
     * <p>
     * This method is used to create Booking Details
     * </p>
     *
     * @param bookingDto it contains booking dto objects
     *
     * @return BookingDto
     */
    BookingResponseDto createBooking(BookingDto bookingDto);

    /**
     * <p>
     * This method List all the Booking Details
     * </p>
     *
     * @return List<BookingDto>
     */
    List<BookingDto> getAllBookings();

    /**
     * <p>
     * This method get the Booking Details which matches the id
     * </p>
     *
     * @param bookingId it contains booking id
     * @return BookingDto
     */
    BookingDto viewByBookingId(int bookingId);

    /**
     * <p>
     * This method is used to cancel the Screen Details which matches the id
     * </p>
     *
     * @param bookingId it contains booking dto object
     * @return BookingDto
     */
    BookingDto cancelBooking(int bookingId);

    /**
     * <p>
     * This method is to calculate the total cost based on the given seat type
     * </p>
     *
     * @param seats it contains list of seat objects
     * @return double
     */
    double calculateTotalCost(List<Seat> seats);

    //Booking cancelSeatBooking(int bookingId, int seatId);
}
