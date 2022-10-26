package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToOne(mappedBy = "booking", cascade = CascadeType.MERGE)
    private Show show;
    private LocalDate bookingDate;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    private double totalCost;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Seat> seats;
}