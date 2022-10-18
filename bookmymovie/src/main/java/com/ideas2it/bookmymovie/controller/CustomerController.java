package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public BookingDto bookMovie(@RequestBody BookingDto bookingDto) {
        return customerService.createBooking(bookingDto);
    }

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<BookingDto>> getAllBookings() throws NotFoundException {
        return new ResponseEntity<>(customerService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/getBookingById/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(customerService.getBookingById(id), HttpStatus.OK);
    }
}
