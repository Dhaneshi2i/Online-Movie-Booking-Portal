package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingCancelledResponseDto;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final ShowService showService;
    private final MapStructMapper mapper;
    private final SeatService seatService;

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
    @Transactional
    public BookingResponseDto createBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.ONPROCESS);

        if (null != bookingDto.getUser()) {
            booking.setUser(mapper.userDtoToUser(userService.getUserById(bookingDto.getUser().getId())));
            booking.setShow(mapper.showResponseDtoToShow(showService.getShowById(bookingDto.getShow().getId())));
            List<Seat> seats = new ArrayList<>();
            for(SeatDto seatDto : bookingDto.getSeats()) {
                seats.add(seatService.getSeatById(seatDto.getId()));
            }
            booking.setTransactionMode(bookingDto.getTransactionMode());
            booking.setBookingDate(LocalDate.now());
            booking.setTotalCost(calculateTotalCost(seats));

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
    public List<BookingDto> getAllBookings(int pageNumber, int pageSize) {
        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Booking> booking = bookingRepository.findAll(p);
        return mapper.bookingListToBookingDtoList(booking.getContent());
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
    public BookingResponseDto viewByBookingId(int bookingId) {
        Booking booking = bookingRepository.findBookingByBookingId(bookingId);
        if (null == booking) {
            throw new NotFoundException("No booking was found for respective id " + bookingId);
        } else {
            return mapper.bookingToBookingResponseDto(booking);
        }
    }

    /**
     * <p>
     * This method get the Booking Details which matches the id
     * </p>
     *
     * @param userId it contains booking id
     * @return BookingResponseDto
     */
    @Override
    public BookingResponseDto viewBookingByUserId(int userId) {
        Booking booking = bookingRepository.findBookingByUser(userId);
        if (null == booking) {
            throw new NotFoundException("No booking was found for respective id " + userId);
        } else {
            return mapper.bookingToBookingResponseDto(booking);
        }
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
    public BookingCancelledResponseDto cancelBooking(int bookingId) throws NotFoundException {
        Booking booking = bookingRepository.findBookingByBookingId(bookingId);
        List<Seat> seats = booking.getSeats();
        for (Seat seat : seats) {
            seatService.cancelSeatBooking(seat);
        }
        booking.setBookingStatus(BookingStatus.CANCELLED);
        booking.setSeats(seats);
        bookingRepository.save(booking);
        return mapper.bookingToBookingCancelledResponseDto(booking);
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
    public float calculateTotalCost(List<Seat> seats) {
        float amount = 0;
        for (Seat seat : seats) {
            amount = amount + seat.getSeatType().getPrice();
        }
        return amount;

    }

    /**
     * <p>
     * This method is to check whether the payment is successful or not
     * </p>
     *
     * @param  booking it contains list of seat objects
     * @return boolean
     */
    public boolean completePayment(Booking booking) {
        return true;
    }

}
