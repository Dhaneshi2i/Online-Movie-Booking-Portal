package com.ideas2it.bookmymovie.model;

import com.ideas2it.bookmymovie.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
