package com.ideas2it.bookmymovie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 * This Screen Class contains details that are required about a screen present in a theatre
 *</p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;

    private String screenName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "screen_seat_type_id")
    private List<SeatType> seatTypes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "theatre_theatre_id", referencedColumnName = "theatreId")
    private Theatre theatre;

    private boolean status;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdOn;

    @UpdateTimestamp
    private Timestamp updatedOn;
}
