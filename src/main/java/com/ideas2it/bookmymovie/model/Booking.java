package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
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

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToOne(mappedBy = "booking")
    private Ticket ticket;
}