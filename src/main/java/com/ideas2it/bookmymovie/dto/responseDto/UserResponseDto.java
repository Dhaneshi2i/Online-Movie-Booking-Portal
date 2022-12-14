package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * User Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
public class UserResponseDto {
    private int id;

    private String userName;

    private String contactNumber;

    private String emailId;

    private RoleResponseDto role;
}
