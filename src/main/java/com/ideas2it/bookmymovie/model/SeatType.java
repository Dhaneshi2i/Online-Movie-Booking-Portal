package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * This SeatType class contains seat type
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seat_type")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int seatTypeId;

    @Column
    private String seatType;

    @Column
    private int noOfColumns;

    @Column
    private int noOfRows;

    @Column
    private double price;

    @OneToMany(mappedBy="seatType")
    private List<Seat> seats;

    @ManyToOne
    @JoinColumn(name="screen", nullable=false)
    private Screen screen;
}
