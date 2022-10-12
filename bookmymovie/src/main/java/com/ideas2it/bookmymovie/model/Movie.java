package com.ideas2it.bookmymovie.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column
    private LocalTime duration;

    @Column(name = " screen_id")
    @OneToMany(mappedBy = "movie")
    private List<Screeing> screening = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "movie_cast",
            joinColumns = {
                    @JoinColumn(name = "movie_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "cast_id")
            }
    )
    private List<Cast> cast = new ArrayList<>();
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "movie_language",
            joinColumns = {
                    @JoinColumn(name = "movie_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "language_id")
            }
    )
    private List<Language> languages = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "movie_genre",
            joinColumns = {
                    @JoinColumn(name = "movie_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "genre_id")
            }
    )
    private List<Genre> genres = new ArrayList<>();
}
