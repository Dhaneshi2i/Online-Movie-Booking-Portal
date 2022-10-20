package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
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
    @JsonIgnore
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screen = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Show> show = new ArrayList<>();
    @Column(name = "status")
    private Boolean status;
    @Column(name = "modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;
    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;
}
