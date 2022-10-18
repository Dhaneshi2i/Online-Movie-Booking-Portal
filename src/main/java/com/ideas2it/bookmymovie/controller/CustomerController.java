package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.CustomerDto;
import com.ideas2it.bookmymovie.model.Customer;
import com.ideas2it.bookmymovie.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public CustomerDto addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/findAll")
    public List<CustomerDto> viewCustomerList() {
        return customerService.viewCustomerList();
    }

    @PatchMapping("/update")
    public CustomerDto updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/view/{customerId}")
    public CustomerDto viewACustomer(@PathVariable int customerId) {
        return  customerService.viewCustomer(customerId);
    }

    /*@PostMapping
    public BookingDto bookMovie(@RequestBody BookingDto bookingDto) {
        return customerService.createBooking(bookingDto);
    }

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<BookingDto>> getAllBookings() throws NotFoundException {
        return new ResponseEntity<>(customerService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/getBookingById/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(customerService.getBookingById(id), HttpStatus.OK);
    }

    @PatchMapping("/updateBooking/{id}/{status}")
    public ResponseEntity<BookingDto> cancelBooking(@PathVariable String id, boolean status) throws NotFoundException {
        return new ResponseEntity<>(customerService.updateBooking(id, status), HttpStatus.OK);
    }*/

}

