package com.ideas2it.bookmymovie.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ElementCollection
    private List<String> seatNo;
    @Column
    private LocalDate booking_date;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "screening_id", referencedColumnName = "id")
    private Screening screening;
    @OneToMany(mappedBy = "booking")
    private List<BookedSeats> bookedSeats = new ArrayList<>();
}
