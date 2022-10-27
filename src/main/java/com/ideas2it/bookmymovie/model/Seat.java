package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int seatId;

    @Column(name = "seat_number")
    private String seatNumber;

    private String type;

    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status")
    private SeatStatus seatStatus = SeatStatus.AVAILABLE;

   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id")
    private Booking booking;*/

    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Timestamp modifiedDate;
}
