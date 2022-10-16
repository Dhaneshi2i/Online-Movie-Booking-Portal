package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.repository.CustomerRepository;
import com.ideas2it.bookmymovie.service.CustomerService;
import com.ideas2it.bookmymovie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;
    private final BookingDto bookingDto;
    private final Booking booking;
    public UserService userService;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper, BookingDto bookingDto,
                               Booking booking) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
        this.bookingDto = bookingDto;
        this.booking = booking;
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        bookingDto.setCreationDate(LocalDate.now());
        return mapper.map(customerRepository.save(mapper.map(bookingDto, Booking.class)), BookingDto.class);
    }

    @Override
    public List<BookingDto> getAllBookings() throws NotFoundException {
        List<Booking> bookings = customerRepository.findAll();
        if (bookings.isEmpty()) {
            throw new NotFoundException("No bookings found");
        }
        return bookings.stream()
                .map(booking -> mapper.map(booking, BookingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(int id) {
        return mapper.map(customerRepository.findById(id), BookingDto.class);
    }
}
