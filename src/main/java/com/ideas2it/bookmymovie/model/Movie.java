package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieName;
    private String duration;

    @Column
    private Boolean Status = false;
    @CreationTimestamp
    @Column
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column
    private Timestamp modifiedDate;
    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "movie_genre",
            joinColumns = {
                    @JoinColumn(name = "movie_id")
            }, inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres = new ArrayList<>();

    @JsonIgnore
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

    @JsonIgnore
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
    private List<Cast> casts = new ArrayList<>();

    private String movieRating;

    private LocalDate movieDate;

    @OneToOne
    private Show show;
}