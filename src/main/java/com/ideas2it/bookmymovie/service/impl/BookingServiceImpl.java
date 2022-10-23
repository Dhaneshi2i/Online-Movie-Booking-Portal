package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.repository.BookingRepository;
import com.ideas2it.bookmymovie.service.BookingService;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.ShowService;
import com.ideas2it.bookmymovie.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final ShowService showService;
    private final MapStructMapper mapper;

    private SeatService seatService;

    public BookingServiceImpl(BookingRepository bookingRepository, UserService userService, ShowService showService,
                                              MapStructMapper mapper, SeatService seatService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.showService = showService;
        this.mapper = mapper;
        this.seatService = seatService;
    }


    @Override
    public BookingDto createBooking(BookingDto bookingDto, int userId, int showId) {
        Booking booking = new Booking();
        if (null != bookingDto) {
            //booking.setUser(mapper.userDtoToUser(userService.getUserById(bookingDto.getUser().getUserId())));
            //booking.setShow(mapper.showDtoToShow(showService.getShowById(bookingDto.getShow().getShowId())));
            booking.setUser(mapper.userDtoToUser(userService.getUserById(userId)));
            booking.setShow(mapper.showDtoToShow(showService.getShowById(showId)));
            List<Seat> seats = mapper.seatDtoListToSeatList(bookingDto.getSeats());
            for(Seat seat :seats) {
                System.out.println("s2 : " + seat.getPrice());
                seatService.bookSeat(seat);
            }
            booking.setSeats(seats);
            booking.setBookingDate(LocalDate.now());
            booking.setTotalCost(calculateTotalCost(seats));
            System.out.println("seat price: " + booking.getTotalCost());
        }

        return mapper.bookingToBookingSlimDto(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream().map(mapper::bookingToBookingDto).collect(Collectors.toList());
    }

    @Override
    public BookingDto viewByBookingId(int bookingId) throws NotFoundException {
        return mapper.bookingToBookingDto(bookingRepository.findById(bookingId).get());
    }

    @Override
    public BookingDto cancelBooking(int bookingId) throws NotFoundException {
        Booking booking = bookingRepository.findById(bookingId).get();
        List<Seat> seats = booking.getSeats();
        for (Seat seat : seats) {
            seatService.cancelSeatBooking(seat);
        }
        booking.setSeats(seats);
        bookingRepository.save(booking);
        return mapper.bookingToBookingDto(booking);
    }

    @Override
    public double calculateTotalCost(List<Seat> seats) {
       // List<Ticket> tickets = mapper.ticketsDtoListToTicketsList(ticketService.getAllTickets());
//        List<Seat> seats = new ArrayList<>();
//        for (Ticket ticket : tickets) {
//            if (bookingId == ticket.getBooking().getTransactionId()) {
//                seats.addAll(ticket.getSeats());
//            }
//        }
        double amount = 0;
        for (Seat seat : seats) {
            amount = amount + seat.getPrice();
            System.out.println("s1 price:" + seat.getPrice());
        }
        //booking = bookingRepository.findById(bookingId).get();
        //booking.setTotalCost(amount);
        //bookingRepository.save(booking);
        System.out.println("seats price: " + amount);
        return amount;
    }

}


   /* @Override
    public BookingDto updateBookings(BookingDto bookingDto) throws NotFoundException{
        bookingRepository.saveAndFlush(mapper.bookingDtoToBooking(bookingDto));
        return mapper.bookingToBookingDto(bookingRepository.findById(bookingDto.getBookingId()).get());
    }

    @Override
    public List<BookingDto> getAllBookingsByMovieId(int movieId) {
        List<Booking> bookings = queryClass.getAllByMovieId(movieId);
        return mapper.bookingListToBookingDtoList(bookings);
    }*/
