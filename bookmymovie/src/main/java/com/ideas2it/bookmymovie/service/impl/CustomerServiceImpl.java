package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.repository.CustomerRepository;
import com.ideas2it.bookmymovie.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;
    private final BookingDto bookingDto;
    private Booking booking;

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
}
