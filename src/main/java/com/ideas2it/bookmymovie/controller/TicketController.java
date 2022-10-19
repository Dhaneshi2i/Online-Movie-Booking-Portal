package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.TicketDto;
import com.ideas2it.bookmymovie.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/ticket")
public class TicketController {
    private TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public TicketDto addTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.addTicket(ticketDto);
    }

    @GetMapping
    public List<TicketDto> getAllTickets() {
        return ticketService.viewTickets();
    }

    @GetMapping("/{ticketId}")
    public TicketDto getTicketById(@PathVariable int ticketId) {
        return ticketService.findTicketById(ticketId);
    }
}
