package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TicketDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Ticket;
import com.ideas2it.bookmymovie.repository.TicketRepository;
import com.ideas2it.bookmymovie.service.BookingService;
import com.ideas2it.bookmymovie.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final BookingService bookingService;
    private final MapStructMapper mapper;

    public TicketServiceImpl(TicketRepository ticketRepository, BookingService bookingService, MapStructMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.bookingService = bookingService;
        this.mapper = mapper;
    }


    @Override
    public TicketDto addTicket(TicketDto ticketDto, int transactionId) {
        Booking booking = new Booking();
        if (transactionId != 0) {
            booking = mapper.bookingDtoToBooking(bookingService.viewByBookingId(transactionId));
            booking.setTransactionStatus("Completed");
            Ticket ticket = mapper.ticketDtoToTicket(ticketDto);
            ticket.setBooking(booking);
        }
        return mapper.ticketToTicketDto(ticketRepository.save(mapper.ticketDtoToTicket(ticketDto)));
    }

    @Override
    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticket -> mapper.ticketToTicketDto(ticket)).collect(Collectors.toList());
    }

    @Override
    public TicketDto findTicketById(int ticketId) throws NotFoundException{
        return ticketRepository.findById(ticketId).map(ticket -> mapper.ticketToTicketDto(ticket))
                .orElseThrow(() -> new NotFoundException("No ticket found for id: " + ticketId));
    }
}
