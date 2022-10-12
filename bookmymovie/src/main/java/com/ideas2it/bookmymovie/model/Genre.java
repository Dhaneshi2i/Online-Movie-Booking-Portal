package com.ideas2it.bookmymovie.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "genre")

public class Genre {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "genre_name")
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.ALL })
    private List<Movie> movies = new ArrayList<>();
}
