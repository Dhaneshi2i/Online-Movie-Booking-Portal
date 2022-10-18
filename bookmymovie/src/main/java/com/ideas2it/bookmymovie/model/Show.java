package com.ideas2it.bookmymovie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
