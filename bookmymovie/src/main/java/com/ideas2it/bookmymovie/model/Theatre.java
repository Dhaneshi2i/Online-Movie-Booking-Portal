package com.ideas2it.bookmymovie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
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

    @Column(name = "status",columnDefinition = "tinyint(1) default true")
    private Boolean status = true;

    @Column(name="modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;

    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;
}
