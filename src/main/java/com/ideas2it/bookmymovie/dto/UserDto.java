package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

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


   

public class UserDto implements Serializable {
    private static final long serialVersionUID = 3710470335120544380L;
    private int id;
    
    @Size(min = 3,max = 40,message = "userName should be only between 3 and 40 characters")

    @Pattern(regexp = Constants.NAME_REGEX, message = "Use only alphabets")
    private String userName;
    @NotBlank(message = "Email id should not be empty")
    @Email(message = "Please, Enter valid user email id")
    private String emailId;
    @NotNull(message = "Contact number should not be empty")
    private long contactNumber;
    @NotBlank(message = "Password should not be empty")
    @Size(max = 20, message = "Please, Enter minimum 18 character")
    private String password;
    private RoleDto role;
    private boolean status;
}


