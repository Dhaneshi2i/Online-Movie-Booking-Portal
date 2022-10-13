package com.ideas2it.bookmymovie.model;

import com.ideas2it.bookmymovie.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "contact_number")
    private long contactNumber;

<<<<<<< HEAD
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;

=======
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
>>>>>>> d109535 (Online-Movie-Booking:)
}
