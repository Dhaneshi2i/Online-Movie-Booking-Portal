package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TicketDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Ticket;
import com.ideas2it.bookmymovie.repository.TicketRepository;
import com.ideas2it.bookmymovie.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private MapStructMapper mapper;

    public TicketServiceImpl(TicketRepository ticketRepository, MapStructMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }

    @Override
    public TicketDto addTicket(TicketDto ticketDto) {
        return mapper.ticketToTicketDto(ticketRepository.save(mapper.ticketDtoToTicket(ticketDto)));
    }

    @Override
    public List<TicketDto> viewTickets() {
        return ticketRepository.findAllByStatus(false).stream()
                .map(ticket -> mapper.ticketToTicketDto(ticket)).collect(Collectors.toList());
    }

    @Override
    public TicketDto findTicketById(int ticketId) throws NotFoundException{
        return ticketRepository.findById(ticketId).map(ticket -> mapper.ticketToTicketDto(ticket))
                .orElseThrow(() -> new NotFoundException("No ticket found for id: " + ticketId));
    }
}
