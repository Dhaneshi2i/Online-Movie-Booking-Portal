package com.ideas2it.bookmymovie.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int movieId;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "release_date")
    private ZonedDateTime releaseDate;

    @Column
    private LocalTime duration;

    @Column(name = " screening_id")
    @OneToMany(mappedBy = "movie")
    private List<Screening> screening = new ArrayList<>();
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
