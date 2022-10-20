package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.slimdto.RoleSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.User} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int userId;
    @NotNull
    @Pattern(regexp = "([A-Z][a-z]{2,30}\\s*)+", message = "Only letter are valid")
    private String userName;
    @NotNull
    @Email
    private String emailId;
    @NotNull
    @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "only number are allowed and they must have 10 numbers")
    private long contactNumber;
    @NotNull
    @Size(max = 20, message = "Must be only between 20 characters")
    @Pattern(regexp = "[a-z0-9_-]+", message = "only number are allowed and they must have 10 numbers")
    private String password;
    private boolean status;
    private RoleSlimDto role;

}


