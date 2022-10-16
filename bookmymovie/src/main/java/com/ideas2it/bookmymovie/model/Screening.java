package com.ideas2it.bookmymovie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int screeningId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "date")
    private LocalDate showDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @OneToMany(mappedBy = "screening")
    private List<BookedSeat> bookedSeats = new ArrayList<>();

    @OneToMany(mappedBy = "screening")
    private List<Booking> bookings = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screen_id")
    private Screen screen;

}
