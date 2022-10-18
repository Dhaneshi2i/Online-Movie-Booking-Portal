package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
<<<<<<< HEAD:bookmymovie/src/main/java/com/ideas2it/bookmymovie/model/Show.java
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "show")
@DynamicUpdate
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal showId;
    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;
    @OneToOne(mappedBy = "show")
    private Movie movie;
=======
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigDecimal showId;

    private LocalDateTime showStartTime;

    private LocalDateTime showEndTime;

    private String showName;

    /*@OneToOne(mappedBy = "show")
    private Movie movie;

>>>>>>> 2390fc0 (Online-Movie-Booking:):src/main/java/com/ideas2it/bookmymovie/model/Show.java
    @JsonIgnore
    @ManyToOne
    private Screen screen;
    @JsonIgnore
    @ManyToOne
<<<<<<< HEAD:bookmymovie/src/main/java/com/ideas2it/bookmymovie/model/Show.java
    private Theatre theatre;
=======
    private Theatre theatre;*/
>>>>>>> 2390fc0 (Online-Movie-Booking:):src/main/java/com/ideas2it/bookmymovie/model/Show.java
    @JsonIgnore
    @OneToOne
    private Booking booking;

<<<<<<< HEAD:bookmymovie/src/main/java/com/ideas2it/bookmymovie/model/Show.java
=======
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
>>>>>>> 2390fc0 (Online-Movie-Booking:):src/main/java/com/ideas2it/bookmymovie/model/Show.java
    private LocalDate showDate;
}
