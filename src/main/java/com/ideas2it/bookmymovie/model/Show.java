package com.ideas2it.bookmymovie.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    private LocalTime showStartTime;
    private LocalTime showEndTime;
    @OneToOne(mappedBy = "show")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    @ManyToOne
    @JoinColumn(name="theatre_id")
    private Theatre theatre;
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    private LocalDate showDate;
    @Column
    private Boolean Status = false;

}
