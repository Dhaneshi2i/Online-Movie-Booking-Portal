package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.repository.CustomerRepository;
import com.ideas2it.bookmymovie.service.CustomerService;
import com.ideas2it.bookmymovie.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final MapStructMapper mapper;

    private BookingDto bookingDto;

    private Booking booking;

    public UserService userService;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapStructMapper mapper, BookingDto bookingDto,
                               Booking booking) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
        this.bookingDto = bookingDto;
        this.booking = booking;
    }

    @Override
    public BookingDto createBooking(BookingDto bookMovie) {
        bookingDto.setCreationDate(LocalDate.now());
        return mapper.bookingToBookingDto(customerRepository.save(mapper.bookingDtoToBooking(bookingDto)));
    }

    @Override
    public List<BookingDto> getAllBookings() throws NotFoundException {
        List<Booking> bookings = customerRepository.findAll();
        if (bookings.isEmpty()) {
            throw new NotFoundException("No bookings found");
        }
        return bookings.stream()
                .map(booking -> mapper.bookingToBookingDto(booking))
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(int id) {
        return mapper.bookingToBookingDto(customerRepository.findById(id));
    }

    @Override
    public BookingDto updateBooking(int id, boolean status) throws NotFoundException {
        booking = customerRepository.findById(id);
        if (null == booking) {
            throw new NotFoundException("No bookings found");
        }
        return mapper.bookingToBookingDto(customerRepository.save(booking));
    }

}
