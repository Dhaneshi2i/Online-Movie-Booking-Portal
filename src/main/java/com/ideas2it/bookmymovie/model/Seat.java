package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This Seat Class contains details that are required about a seat in a screen
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @Column(name = "id", nullable = false)
    private int seatId;

    @Column(name = "seat_number")
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name="seatTypeId", nullable=false)
    private SeatType seatType;

    private LocalDate showDate;

    private LocalTime showStartTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id_id")
    private Screen screen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_show_id")
    private Show show;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status")
    private SeatStatus seatStatus = SeatStatus.AVAILABLE;

    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Timestamp updatedOn;
}
