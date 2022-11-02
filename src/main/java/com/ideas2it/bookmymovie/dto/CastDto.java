package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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
public class CastDto implements Serializable  {

    private int id;
    @NotBlank
    private String castName;
    @NotBlank
    private String castRole;

}
