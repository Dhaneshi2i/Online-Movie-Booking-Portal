package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * Cast Dto class contains the cast dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class CastDto {

    private int castId;
    @NotBlank(message = "Cast should not be empty")
    private String castName;
    @NotBlank(message = "Cast role should not be empty")
    @Pattern(regexp="^(Actor|Actress|Director)$",message="Invalid cast role. Valid values are 1. Actor 2. Actress 3. Director")
    private String castRole;

}
