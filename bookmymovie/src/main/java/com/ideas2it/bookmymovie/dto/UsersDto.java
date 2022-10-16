package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Users} entity
 */
@Getter
@Setter
@NoArgsConstructor
@Component
public class UsersDto {
    private int userId;
    private String name;
    private String emailId;
    private long contactNumber;
    private String password;
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private boolean status;
    @JsonBackReference
    private RoleDto role;
}

