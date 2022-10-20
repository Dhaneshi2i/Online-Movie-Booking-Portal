package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.model.Ticket;
import com.ideas2it.bookmymovie.model.User;
import com.ideas2it.bookmymovie.repoImpl.QueryClass;
import com.ideas2it.bookmymovie.repository.BookingRepository;
import com.ideas2it.bookmymovie.service.BookingService;
import com.ideas2it.bookmymovie.service.ShowService;
import com.ideas2it.bookmymovie.service.TicketService;
import com.ideas2it.bookmymovie.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final ShowService showService;
    private final TicketService ticketService;
    private User user;
    private Booking booking;
    private final MapStructMapper mapper;
    private QueryClass queryClass;

    public BookingServiceImpl(BookingRepository bookingRepository, UserService userService, ShowService showService,
                              @Lazy TicketService ticketService, User user, Booking booking,
                              MapStructMapper mapper, QueryClass queryClass) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.showService = showService;
        this.ticketService = ticketService;
        this.user = user;
        this.booking = booking;
        this.mapper = mapper;
        this.queryClass = queryClass;
    }


    @Override
    public BookingDto createBooking(BookingDto bookMovie, int userId, int showId) {
        Show show = new Show();
        if (showId != 0) {
            //show = mapper.showDtoToShow(showService.getshowById(showId));
            show.setBooking(mapper.bookingDtoToBooking(bookMovie));
            booking.setShow(show);
        }
        if (userId != 0) {
            user = mapper.userDtoToUser(userService.getUserById(userId));
            booking.setUser(user);
        }
        //showService.createShow(mapper.showToShowDto(show));
        bookingRepository.saveAndFlush(booking);
        return mapper.bookingToBookingDto(bookingRepository.findById(bookMovie.getTransactionId()).get());
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream().map(mapper::bookingToBookingDto).collect(Collectors.toList());
    }

    @Override
    public BookingDto updateBookings(BookingDto bookingDto) throws NotFoundException{
        bookingRepository.saveAndFlush(mapper.bookingDtoToBooking(bookingDto));
        return mapper.bookingToBookingDto(bookingRepository.findById(bookingDto.getTransactionId()).get());
    }

    @Override
    public BookingDto viewByBookingId(int bookingId) throws NotFoundException {
        return mapper.bookingToBookingDto(bookingRepository.findById(bookingId).get());
    }

    @Override
    public BookingDto cancelBooking(int bookingId) throws NotFoundException {
        booking = bookingRepository.findById(bookingId).get();
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
        List<Ticket> tickets = mapper.ticketsDtoListToTicketsList(ticketService.getAllTickets());
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
        booking = bookingRepository.findById(bookingId).get();
        booking.setTotalCost(amount);
        bookingRepository.save(booking);
        return amount;
    }

}
