package com.ideas2it.bookmymovie.model;

import com.ideas2it.bookmymovie.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
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

    @Column(name = "password")
    private String password;


}
