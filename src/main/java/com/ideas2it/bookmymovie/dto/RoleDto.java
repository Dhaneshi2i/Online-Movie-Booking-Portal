package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * Role Dto class contains the role dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/


@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private int roleId;
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Please, Enter valid role")
    private String roleType;
}
