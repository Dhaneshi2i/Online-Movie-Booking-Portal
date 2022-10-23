package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int bookingId;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "booking")
    private Show show;
    private LocalDate bookingDate;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    private double totalCost;
    @OneToMany
    private List<Seat> seats;
}