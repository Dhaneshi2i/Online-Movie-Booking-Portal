package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public BookingDto bookMovie(@RequestBody BookingDto bookingDto) {
        return customerService.createBooking(bookingDto);
    }
}
