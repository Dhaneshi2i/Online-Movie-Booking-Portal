package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;

    private String theatreName;

    private String theatreCity;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Screen> screen = new ArrayList<>();

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Show> show = new ArrayList<>();

    private boolean status = false;

    @UpdateTimestamp
    private Timestamp modifiedDate;

    @CreationTimestamp
    private Timestamp createdDate;
}
