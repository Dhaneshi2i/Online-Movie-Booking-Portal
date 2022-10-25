package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.SeatDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private UserService userService;
    private ShowService showService;
    private MapStructMapper mapper;

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
            booking.setUser(mapper.userDtoToUser(userService.getUserById(userId)));
            booking.setShow(mapper.showDtoToShow(showService.getShowById(showId)));
            List<Seat> seats = new ArrayList<>();
            for(SeatDto seatDto : bookingDto.getSeats()) {
                Seat selectedSeat = seatService.getSeatBYId(seatDto.getSeatId());
                seatService.bookSeat(selectedSeat);
                seats.add(selectedSeat);
            }
            booking.setSeats(seats);
            booking.setBookingDate(LocalDate.now());
            double cost = calculateTotalCost(seats);
            bookingDto.setTotalCost(cost);
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
        double amount = 0;
        for (Seat seat : seats) {
            amount = seat.getPrice();
        }
        return amount;

    }
    public Booking cancelSeatBooking(int bookingId, int seatId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        Seat seats = seatService.getSeatBYId(seatId);
        booking.getSeats().remove(seats);
        return bookingRepository.save(booking);

    }

}
