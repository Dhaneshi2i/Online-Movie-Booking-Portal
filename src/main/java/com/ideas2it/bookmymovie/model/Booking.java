package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * This Booking Class contains details of booking done by a user
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String transactionMode;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;
    private LocalDate bookingDate;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.ONPROCESS;
    private float totalCost;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Seat> seats;

}