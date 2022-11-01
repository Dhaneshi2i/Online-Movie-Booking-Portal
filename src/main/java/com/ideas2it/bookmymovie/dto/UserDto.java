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
 * <p>
 * User Dto class contains the user dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor

public class UserDto {

    private int userId;

    @Size(min = 3,max = 40,message = "userName should be only between 3 and 40 characters")
    @Pattern(regexp = Constants.NAME_REGEX, message = "Use only alphabets")
    private String userName;
    @NotBlank
    @Email(message = "Please, Enter valid user email id")
    private String emailId;
    @NotNull
    private long contactNumber;
    @NotBlank
    @Size(max = 20, message = "Please, Enter valid password")
    private String password;
    private RoleDto role;
    private boolean status;
}


