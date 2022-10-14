package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
>>>>>>> 20f47ba (Movie-Ticket-Booking:)

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Users} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UsersDto {
    private int userId;
    private String name;
    private String emailId;
    private long contactNumber;
    private String password;
    private RoleDto role;
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private boolean status;
}

