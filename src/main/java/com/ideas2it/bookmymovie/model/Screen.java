package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
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
    @Column(name = "id")
    private int screenId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    private String screenName;

    @Column(name = "no_of_rows")
    private int noOfRows;

    @Column(name = "no_of_columns")
    private int noOfColumns;

    @OneToMany(mappedBy="screen")
    private List<SeatType> typesOfSeats;

    @Column(name = "status")
    private boolean status;

    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Timestamp updatedOn;

}
