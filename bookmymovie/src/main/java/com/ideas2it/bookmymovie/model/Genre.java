package com.ideas2it.bookmymovie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> 20f47ba (Movie-Ticket-Booking:)

@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long GenreId;

    @Column(name = "genre_name")
    private String name;

//    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.ALL })
//    private List<Movie> movies = new ArrayList<>();

<<<<<<< HEAD

=======
>>>>>>> 20f47ba (Movie-Ticket-Booking:)
}
