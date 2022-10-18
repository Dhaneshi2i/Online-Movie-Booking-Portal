package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Component
@Table
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal theatreId;

    private String theatreName;

    private String theatreCity;

    private String managerName;

    private String managerContact;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screen = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Show> show = new ArrayList<>();

    @Column(name = "status", columnDefinition = "tinyint(1) default true")
    private Boolean status = true;

    @Column(name = "modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;

    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;
}
