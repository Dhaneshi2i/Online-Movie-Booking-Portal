package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Component
@Table(name = "theatre")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "theatreId")
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

    @Column(name = "status")
    private Boolean status;

    @Column(name="modified_date")
    private LocalDate modifiedDate;

}
