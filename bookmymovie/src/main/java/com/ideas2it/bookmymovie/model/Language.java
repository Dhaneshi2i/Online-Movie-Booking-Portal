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
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long languageId;

    @Column(name = "language")
    private String name;

    @ManyToMany(mappedBy = "languages", cascade = { CascadeType.ALL })
    private List<Movie> movies = new ArrayList<>();

}
