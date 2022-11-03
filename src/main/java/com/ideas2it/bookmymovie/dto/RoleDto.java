package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

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
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 3710470335120544380L;

    private int id;

    @NotBlank(message = "Role should not be empty")
    @Pattern(regexp="^(Admin|Customer)$",message="Invalid ROLE . Valid Values are 1. Admin 2. Customer")
    private String roleType;
}
