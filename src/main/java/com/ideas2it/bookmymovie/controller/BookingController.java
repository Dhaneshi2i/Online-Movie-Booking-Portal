package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/booking")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{showId}/{userId}")
    public BookingDto bookTickets(@RequestBody BookingDto bookingDto, @RequestParam int showId,
                                  @RequestParam int userId) {
        return bookingService.createBooking(bookingDto, userId, showId);
    }

    @GetMapping
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public BookingDto viewByBookingId(@PathVariable int bookingId) {
        return bookingService.viewByBookingId(bookingId);
    }

    @PutMapping
    public BookingDto updateTicketBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.updateBookings(bookingDto);
    }

    @DeleteMapping("/{bookingId}")
    public BookingDto deleteBookingById(@PathVariable int bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    @GetMapping("/{movieId}")
    public List<BookingDto> viewMovieByMovieId(@PathVariable int movieId) {
        return bookingService.getAllBookingsByMovieId(movieId);
    }

    @GetMapping("/cost/{bookingId}")
    public double totalBookingCost(@PathVariable int bookingId) {
        return bookingService.calculateTotalCost(bookingId);
    }

}
