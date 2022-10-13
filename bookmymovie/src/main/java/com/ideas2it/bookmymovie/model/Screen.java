package com.ideas2it.bookmymovie.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "screen")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int screenId;

    @Column(name = "no_of_seats")
    private int noOfSeats;

    @Column(name = "no_of_rows")
    private int noOfRows;

    @Column(name = "no_of_columns")
    private int noOfColumns;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "screen")
    private List<Screening> screenings = new ArrayList<>();
}
