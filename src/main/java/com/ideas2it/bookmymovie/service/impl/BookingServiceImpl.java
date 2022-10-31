package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingResponseDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.BookingStatus;
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

    /**
     * <p>
     * This method is used to create Booking Details
     * </p>
     *
     * @param bookingDto it contains booking dto objects
     *
     * @return BookingDto
     */
    @Override
    public BookingResponseDto createBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        if (null != bookingDto) {
            booking.setUser(mapper.userDtoToUser(userService.getUserById(bookingDto.getUser().getUserId())));
            booking.setShow(mapper.showDtoToShow(showService.getShowById(bookingDto.getShow().getShowId())));
            List<Seat> seats = new ArrayList<>();
            for(SeatDto seatDto : bookingDto.getSeats()) {
                Seat selectedSeat = seatService.getSeatBYId(seatDto.getSeatId());
                seats.add(selectedSeat);
            }
            booking.setBookingDate(LocalDate.now());
            //booking.setTotalCost(calculateTotalCost(seats));

            boolean isPaymentSuccessful = completePayment(booking);
            if (isPaymentSuccessful) {
                for (Seat seat : seats) {
                    seatService.bookSeat(seat);
                }
                booking.setSeats(seats);
                booking.setBookingStatus(BookingStatus.COMPLETED);
                bookingRepository.save(booking);
            } else {
                booking.setBookingStatus(BookingStatus.CANCELLED);
                bookingRepository.save(booking);
            }
        }
        return mapper.bookingToBookingResponseDto(bookingRepository.save(booking));
    }

    /**
     * <p>
     * This method List all the Booking Details
     * </p>
     *
     * @return List<BookingDto>
     */
    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream().map(mapper::bookingToBookingDto).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method get the Booking Details which matches the id
     * </p>
     *
     * @param bookingId it contains booking id
     * @return BookingDto
     */
    @Override
    public BookingDto viewByBookingId(int bookingId) throws NotFoundException {
        return mapper.bookingToBookingDto(bookingRepository.findById(bookingId).get());
    }

    /**
     * <p>
     * This method is used to cancel the Screen Details which matches the id
     * </p>
     *
     * @param bookingId it contains booking dto object
     * @return BookingDto
     */
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

    /**
     * <p>
     * This method is to calculate the total cost based on the given seat type
     * </p>
     *
     * @param  seats it contains list of seat objects
     * @return double
     */
    @Override
    public double calculateTotalCost(List<Seat> seats) {
        double amount = 0;
        for (Seat seat : seats) {
            amount = amount + seat.getSeatType().getPrice();
        }
        return amount;

    }

    public boolean completePayment(Booking booking) {
        return true;
    }

    /*public Booking cancelSeatBooking(int bookingId, int seatId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        Seat seats = seatService.getSeatBYId(seatId);
        booking.getSeats().remove(seats);
        return bookingRepository.save(booking);
    }*/
}
