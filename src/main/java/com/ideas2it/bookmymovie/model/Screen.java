package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

/**
 * This Screen Class contains details that are required about a screen present in a theatre
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;
    private String screenName;
    @OneToMany(fetch = FetchType.LAZY)
    private List<SeatType> typesOfSeats;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
    private boolean status;
    @CreationTimestamp
    private Timestamp createdOn;
    @UpdateTimestamp
    private Timestamp updatedOn;

}
