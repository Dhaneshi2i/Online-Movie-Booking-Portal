package com.ideas2it.bookmymovie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
<<<<<<< HEAD:bookmymovie/src/main/java/com/ideas2it/bookmymovie/model/Genre.java
    private int genreId;

    @Column(name = "genre_name")
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.ALL })
    private List<Movie> movies = new ArrayList<>();

}
=======
    private BigDecimal userId;
    private String userName;
    private String password;
    private String role;
    @OneToOne
    private Customer customer;
}
>>>>>>> 2390fc0 (Online-Movie-Booking:):src/main/java/com/ideas2it/bookmymovie/model/User.java
