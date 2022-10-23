package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.TicketDto;
import com.ideas2it.bookmymovie.service.BookingService;
import com.ideas2it.bookmymovie.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private final BookingService bookingService;
    private final TicketService ticketService;

    public BookingController(BookingService bookingService, TicketService ticketService) {
        this.bookingService = bookingService;
        this.ticketService = ticketService;
    }


    @PostMapping("/bookTicket")
    public BookingDto bookTicket(@RequestBody BookingDto bookingDto , @RequestParam int userId, @RequestParam int showId ) {
        return bookingService.createBooking(bookingDto, userId, showId);
    }

    @PostMapping("/payment")
    public TicketDto ticketPayment(@RequestBody TicketDto ticketDto) {
        return ticketService.ticketPayment(ticketDto);
    }

    @GetMapping
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public BookingDto viewByBookingId(@PathVariable int bookingId) {
        return bookingService.viewByBookingId(bookingId);
    }

    @PatchMapping("/{bookingId}")
    public BookingDto cancelBookingById(@PathVariable int bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    /*@GetMapping("/{movieId}")
    public List<BookingDto> viewMovieByMovieId(@PathVariable int movieId) {
        return bookingService.getAllBookingsByMovieId(movieId);
    }*/

/*
    @GetMapping("/cost/{bookingId}")
    public double totalBookingCost(@PathVariable int bookingId) {
        return bookingService.calculateTotalCost(bookingId);
    }
*/
    /* @PutMapping
    public BookingDto updateTicketBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.updateBookings(bookingDto);
    }*/

}
