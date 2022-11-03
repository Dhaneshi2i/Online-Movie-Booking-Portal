package com.ideas2it.bookmymovie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This Theatre Class contains details that are required about a theatre
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre implements Serializable {

    private static final long serialVersionUID = 3710470335120544380L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;

    private String theatreName;

    private String theatreCity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    private List<Show> shows = new ArrayList<>();

    private boolean status;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdOn;

    @UpdateTimestamp
    private Timestamp updateOn;
}
