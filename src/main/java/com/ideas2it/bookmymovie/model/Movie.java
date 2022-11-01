package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This Movie Class contains details that are required about a movie
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieName;
    private LocalTime duration;
    private LocalDate releaseDate;

    @ManyToMany(cascade = {
            CascadeType.MERGE
    })
    @JoinTable(
            name = "movie_genre",
            joinColumns = {
                    @JoinColumn(name = "movie_id")
            }, inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.MERGE
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
            CascadeType.MERGE
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

    private boolean status;
    @CreationTimestamp
    private Timestamp createdOn;
    @UpdateTimestamp
    private Timestamp updatedOn;

}


