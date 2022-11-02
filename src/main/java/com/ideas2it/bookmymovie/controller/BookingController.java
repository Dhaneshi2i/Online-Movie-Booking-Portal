package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingResponseDto;
import com.ideas2it.bookmymovie.service.BookingService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * BookingController will get the detail from customer
 * To book the ticket and cancel the ticket,list all the bookings
 * Done by the customer.
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * <p>
     * This method is used to create Booking Details
     * </p>
     *
     * @param bookingDto it contains booking dto objects
     *
     * @return BookingDto
     */
    @PostMapping
    public BookingResponseDto bookTicket(@Valid @RequestBody BookingDto bookingDto) {
        return bookingService.createBooking(bookingDto);
    }

    /**
     * <p>
     * This method List all the Booking Details
     * </p>
     *
     * @return List<BookingDto>
     */
    @GetMapping
    public List<BookingDto> getAllBookings(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return bookingService.getAllBookings(pageNumber, pageSize);
    }

    /**
     * <p>
     * This method get the Booking Details which matches the id
     * </p>
     *
     * @param bookingId it contains booking id
     * @return BookingDto
     */
    @GetMapping("/{bookingId}")
    @Cacheable(value = "booking")
    public BookingResponseDto viewByBookingId(@PathVariable int bookingId) {
        return bookingService.viewByBookingId(bookingId);
    }

    /**
     * <p>
     * This method get the Booking Details which matches the id
     * </p>
     *
     * @param userId it contains booking id
     * @return BookingResponseDto
     */
    @GetMapping("/get-by-user/userId")
    @Cacheable(value = "booking",key = "#userId")
    public BookingResponseDto viewBookingByUserId(@PathVariable int userId) {
        return bookingService.viewBookingByUserId(userId);
    }

    /**
     * <p>
     * This method is used to cancel the Screen Details which matches the id
     * </p>
     *
     * @param bookingId it contains booking dto object
     * @return BookingDto
     */
    @PatchMapping("/cancel-booking/{bookingId}")
    public BookingResponseDto cancelBookingById(@PathVariable int bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

}