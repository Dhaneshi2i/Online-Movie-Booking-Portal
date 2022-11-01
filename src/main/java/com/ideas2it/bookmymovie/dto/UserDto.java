package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class UserDto {

    private int userId;
    @Size(min = 3,max = 40,message = "userName should be only between 3 and 40 characters")
    @Pattern(regexp = Constants.NAME_REGEX, message = "Use only alphabets")
    private String userName;
    @NotBlank
    @Email(message = "Email should be valid")
    private String emailId;
    @NotNull
    private long contactNumber;
    @NotBlank
    @Size(max = 20, message = "Must be only between 20 characters")
    private String password;
    private RoleDto role;
    private boolean status;
}


