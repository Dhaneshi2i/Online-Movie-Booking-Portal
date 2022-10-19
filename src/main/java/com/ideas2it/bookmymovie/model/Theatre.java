package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;
    private String theatreName;
    private String theatreCity;
    private String managerName;
    private String managerContact;
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screen = new ArrayList<>();
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Show> show = new ArrayList<>();
    @Column(name = "status", columnDefinition = "tinyint(1) default true")
    private Boolean status = false;
    @Column(name = "modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;
    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;
}
