package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.TicketDto;
import com.ideas2it.bookmymovie.service.TicketService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/V1/ticket")
public class TicketController {
    private TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/")
    public TicketDto addTicket(@RequestBody TicketDto ticketDto, @RequestParam int transactionId) {
        return ticketService.addTicket(ticketDto,transactionId);
    }

    @GetMapping("/")
    public List<TicketDto> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{ticketId}")
    public TicketDto getTicketById(@PathVariable int ticketId) {
        return ticketService.findTicketById(ticketId);
    }
}
