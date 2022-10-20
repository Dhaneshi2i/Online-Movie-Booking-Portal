package com.ideas2it.bookmymovie.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    @JsonIgnore
    @OneToOne(mappedBy = "show")
    private Movie movie;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="theatre_id")
    private Theatre theatre;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    private LocalDate showDate;
    @Column
    private Boolean Status = false;

}
