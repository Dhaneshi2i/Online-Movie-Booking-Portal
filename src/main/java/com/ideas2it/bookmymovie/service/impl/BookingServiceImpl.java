package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.model.Ticket;
import com.ideas2it.bookmymovie.model.User;
import com.ideas2it.bookmymovie.repoImpl.QueryClass;
import com.ideas2it.bookmymovie.repository.BookingRepository;
import com.ideas2it.bookmymovie.repository.ShowRepository;
import com.ideas2it.bookmymovie.repository.TicketRepository;
import com.ideas2it.bookmymovie.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private ShowRepository showRepository;
    private TicketRepository ticketRepository;
    private Booking booking;
    private Show show;
    private final MapStructMapper mapper;
    private QueryClass queryClass;

    public BookingServiceImpl(BookingRepository bookingRepository, Booking booking, MapStructMapper mapper) {
        this.bookingRepository = bookingRepository;
        this.booking = booking;
        this.mapper = mapper;
    }

    @Override
    public BookingDto createBooking(BookingDto bookMovie, int userId, int showId) {
        if (showId != 0) {
            show = showRepository.findById(showId).get();
            booking.setShow(show);
        }
        showRepository.save(show);
        bookingRepository.save(booking);
        return mapper.bookingToBookingDto(bookingRepository.findById(bookMovie.getTransactionId()).get());
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream().map(mapper::bookingToBookingDto).collect(Collectors.toList());
    }

    @Override
    public BookingDto updateBookings(BookingDto bookingDto) throws NotFoundException{
        return mapper.bookingToBookingDto(bookingRepository.save(mapper.bookingDtoToBooking(bookingDto)));
        //return null;
    }

    @Override
    public BookingDto viewByBookingId(int bookingId) throws NotFoundException {
        return mapper.bookingToBookingDto(bookingRepository.findById(bookingId).get());
    }

    @Override
    public BookingDto cancelBooking(int bookingId) throws NotFoundException {
        booking = bookingRepository.findByBookingId(bookingId).get();
        bookingRepository.delete(booking);
        return mapper.bookingToBookingDto(booking);
    }

    @Override
    public List<BookingDto> getAllBookingsByMovieId(int movieId) {
        List<Booking> bookings = queryClass.getAllByMovieId(movieId);
        return mapper.bookingListToBookingDtoList(bookings);
    }

    @Override
    public double calculateTotalCost(int bookingId) {
        List<Ticket> tickets = ticketRepository.findAll();
        List<Seat> seats = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (bookingId == ticket.getBooking().getTransactionId()) {
                seats.addAll(ticket.getSeats());
            }
        }
        double amount = 0;
        for (Seat seat : seats) {
            amount = amount + seat.getPrice();
        }
        booking = bookingRepository.findByBookingId(bookingId).get();
        booking.setTotalCost(amount);
        bookingRepository.save(booking);
        return amount;
    }

}
