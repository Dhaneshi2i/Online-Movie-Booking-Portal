package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto addTicket(TicketDto ticketDto);
    List<TicketDto> viewTickets();

    TicketDto findTicketById(int ticketId);
}
