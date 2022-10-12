package com.ideas2it.bookmymovie.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "language")
@Data
public class Language {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    private String name;

    @ManyToMany(mappedBy = "languages", cascade = { CascadeType.ALL })
    private List<Movie> movies = new ArrayList<>();

}
