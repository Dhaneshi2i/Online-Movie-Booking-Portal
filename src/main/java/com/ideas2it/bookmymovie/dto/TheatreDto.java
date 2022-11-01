package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * Theatre Dto class contains the theatre dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor

public class TheatreDto {
    private int theatreId;
    @NotBlank(message = "Please, Enter theatre name. Theatre name should not be empty")
    private String theatreName;
    @NotBlank(message = "Please, Enter theatre city. Theatre location should not empty")
    private String theatreCity;
}
