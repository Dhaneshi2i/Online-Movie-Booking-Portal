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
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "contact_number")

    private long contactNumber;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Timestamp modifiedDate;


    @Column(name = "status")
    private boolean status = false;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
