package com.ideas2it.bookmymovie.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int theatreId;

    @Column(name = "name")
    private String name;

    @Column(name = "city_Name")
    private String cityName;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens = new ArrayList<>();

}
