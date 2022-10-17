package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @Pattern(regexp = "([A-Z][a-z]{2,30}\\s*)+", message = "Only letter are valid")
    private String name;

    @Email
    private String emailId;

    //@NotNull
    //@Pattern(regexp = "[6-9][0-9]{9}", message = "only number are allowed and they must have 10 numbers")
    private long contactNumber;

    @Size(max = 20, message = "Must be only between 20 characters")
    @Pattern(regexp = "[a-z0-9_-]+", message = "only number are allowed and they must have 10 numbers")
    private String password;

    private LocalDate creationDate;

    private LocalDate modifiedDate;

    private boolean status;

    private RoleDto role;

}

