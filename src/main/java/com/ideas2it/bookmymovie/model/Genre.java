package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int genreId;

    @Column
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private List<Movie> movies = new ArrayList<>();

}
