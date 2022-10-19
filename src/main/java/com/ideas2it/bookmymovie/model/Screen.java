package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

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
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;

    @JsonIgnore
    @ManyToOne
    private Theatre theatre;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Show> show = new ArrayList<>();

    private String screenName;

    @Column(name = "rows")
    private int rows;

    @Column(name = "columns")
    private int columns;

    @Column(name = "status", columnDefinition = "tinyint(1) default true")
    private Boolean status = true;

    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Timestamp modifiedDate;
}
