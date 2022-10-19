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
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private int showId;
   private LocalTime showStartTime;
   private LocalTime showEndTime;
   @OneToOne(mappedBy = "show")
   private Movie movie;
   @ManyToOne
   private Screen screen;
   @ManyToOne
   private Theatre theatre;
   @OneToOne
   private Booking booking;
   private LocalDate showDate;
}
