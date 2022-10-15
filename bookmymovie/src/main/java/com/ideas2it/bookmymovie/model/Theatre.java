package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "theatre")
@Where(clause="status=1")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int theatreId;

    @Column(name = "name")
    private String name;

    @Column(name = "city_Name")
    private String cityName;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens = new ArrayList<>();

    @Column(columnDefinition = "tinyint(1) default true")
    private Boolean status = true;

}
