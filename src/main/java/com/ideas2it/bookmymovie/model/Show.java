package com.ideas2it.bookmymovie.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "show")
@DynamicUpdate
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int showId;
    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;
    @OneToOne(mappedBy = "show")
    private Movie movie;
    @JsonIgnore
    @ManyToOne
    private Screen screen;
    @JsonIgnore
    @ManyToOne
    private Theatre theatre;
    @JsonIgnore
    @OneToOne
    private Booking booking;
   private LocalDate showDate;
}
