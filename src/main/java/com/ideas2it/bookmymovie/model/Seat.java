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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int seatId;

    @Column(name = "seat_number")
    private String seatNumber;

    private String type;

    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status")
    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "status", columnDefinition = "tinyint(1) default true")
    private Boolean status = false;

    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Timestamp modifiedDate;

}
