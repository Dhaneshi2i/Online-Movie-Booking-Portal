package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByStatus(boolean status);
    Ticket findByTicketId(int ticketId);
}
