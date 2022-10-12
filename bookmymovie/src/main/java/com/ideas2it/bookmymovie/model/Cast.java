package com.ideas2it.bookmymovie.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "cast")

public class Cast {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "cast_name")
    private String name;

    @Column(name = "cast_role")
    private String role;


    @ManyToMany(mappedBy = "cast", cascade = { CascadeType.ALL })
    private List<Movie> movies = new ArrayList<>();

}
