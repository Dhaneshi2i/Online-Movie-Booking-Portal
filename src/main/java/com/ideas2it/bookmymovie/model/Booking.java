package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int transactionId;

    @OneToOne(mappedBy = "booking")
    private Show show;

    private LocalDate bookingDate;

    private String transactionMode;

    private String transactionStatus;

    private double totalCost;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "booking")
    private Ticket ticket;
}