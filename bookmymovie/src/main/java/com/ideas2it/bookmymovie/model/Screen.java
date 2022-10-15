package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "screen")
@Where(clause="status=1")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(columnDefinition = "tinyint(1) default true")
    private Boolean status = true;
}
