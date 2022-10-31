package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ideas2it.bookmymovie.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String userName;
    @NotBlank
    @Email
    private String emailId;
    @NotNull
    private long contactNumber;
    @NotBlank
    @Size(max = 20, message = "Must be only between 20 characters")
    @Pattern(regexp = Constants.PASSWORD_REGEX, message = "only number are allowed and they must have 10 numbers")
    private String password;
    @NotNull
    private RoleDto role;

}


