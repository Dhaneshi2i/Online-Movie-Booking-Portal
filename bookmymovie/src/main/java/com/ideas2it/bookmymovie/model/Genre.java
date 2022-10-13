package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "genre_name")
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.ALL })
    private List<Movie> movies = new ArrayList<>();

    public Genre(int id, String name, List<Movie> movies) {
    }
}
