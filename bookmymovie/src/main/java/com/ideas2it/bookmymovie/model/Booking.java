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

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    @OneToOne(mappedBy = "booking")
    private Show show;
    private LocalDate bookingDate;
    private String transactionMode;
    private String transactionStatus;
    private double totalCost;
    @JsonIgnore
    @ManyToOne

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

     

    @ManyToOne
    @JoinColumn(name = "screening_id", referencedColumnName = "id")
    private Screening screening;

    @OneToMany(mappedBy = "booking")
    private List<BookedSeat> bookedSeats = new ArrayList<>();

    @Column(name = "created_date")
    private LocalDate creationDate;

    @Column(name = "modified_date")
    private LocalDate modifiedDate;

    @Column(name = "status")
    private boolean status;

}
