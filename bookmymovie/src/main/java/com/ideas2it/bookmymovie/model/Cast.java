package com.ideas2it.bookmymovie.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long castId;

    @Column(name = "cast_name")
    private String name;

    @Column(name = "cast_role")
    private String role;


    @ManyToMany(mappedBy = "cast", cascade = { CascadeType.ALL })
    private List<Movie> movies = new ArrayList<>();

}
