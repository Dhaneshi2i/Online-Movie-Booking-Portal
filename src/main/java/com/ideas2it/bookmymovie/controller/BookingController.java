package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.TicketDto;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.repository.BookingRepository;
import com.ideas2it.bookmymovie.repository.SeatRepository;
import com.ideas2it.bookmymovie.service.BookingService;
import com.ideas2it.bookmymovie.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private BookingService bookingService;
    private TicketService ticketService;

    public BookingController(BookingService bookingService, TicketService ticketService) {
        this.bookingService = bookingService;
        this.ticketService = ticketService;
    }

    @PostMapping("/bookTicket")
    public BookingDto bookTicket(@RequestBody BookingDto bookingDto, @RequestParam int userId, @RequestParam int showId) {
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

    @DeleteMapping("/{bookingId}/{seatId}")
    public Booking ticketCancel(@PathVariable int bookingId, @PathVariable int seatId) {
        return bookingService.cancelSeatBooking(bookingId, seatId);
    }
}
