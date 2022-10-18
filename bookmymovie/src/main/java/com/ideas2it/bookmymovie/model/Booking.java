package com.ideas2it.bookmymovie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Component
@Table(name = "booking")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int bookingId;

    @ElementCollection
    private List<String> seatNo;

    @Column
    private LocalDate bookingDate;

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
