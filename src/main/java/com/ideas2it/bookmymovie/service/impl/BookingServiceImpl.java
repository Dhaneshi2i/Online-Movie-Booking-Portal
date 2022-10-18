package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.repository.BookingRepository;
import com.ideas2it.bookmymovie.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private Screening screening;
    private Booking booking;
    private final MapStructMapper mapper;

    public BookingServiceImpl(BookingRepository bookingRepository, Booking booking, MapStructMapper mapper) {
        this.bookingRepository = bookingRepository;
        this.booking = booking;
        this.mapper = mapper;
    }


    @Override
    public BookingDto createBooking(BookingDto bookMovie) {
        Random random = new Random();
        booking = mapper.bookingDtoToBooking(bookMovie);
        booking.setBookingId(bookMovie.getUsers().getName().toUpperCase()+""+bookMovie.getScreening()
                .getScreeningId()+""+random.nextInt());
        return mapper.bookingToBookingDto(bookingRepository.save(mapper.bookingDtoToBooking(bookMovie)));
    }

    /*public BookingDto cancelBooking(BookingDto bookingDto) {
           return booking.setBookingId(booking.getBookingId());
           //return bookingRepository.updateBookingStatus(bookingDto.getBookingId());
           //booking.setBookingId(bookingDto.getBookingId());
           //booking.setBookingStatus(false);
        //return mapper.bookingToBookingDto(bookingRepository.save(booking));

    }*/

    public BookingDto adminReserve(BookingDto register) {
            //bookingJpaRepository.reserveSeat(register.getShow().getShowId(),register.getSeatno());
            return mapper.bookingToBookingDto(bookingRepository.save(mapper.bookingDtoToBooking(register)));


    }


}
