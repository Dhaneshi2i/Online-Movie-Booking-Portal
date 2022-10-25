package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int ticketId;

    private int noOfSeats;

    private boolean ticketStatus = true;

    @OneToMany( fetch = FetchType.LAZY)
    private List<Seat> seats;

    @OneToOne(fetch = FetchType.EAGER)
    private Booking booking;
}