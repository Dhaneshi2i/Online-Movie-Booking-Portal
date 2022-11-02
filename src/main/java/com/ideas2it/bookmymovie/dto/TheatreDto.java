package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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

public class TheatreDto implements Serializable{
    private static final long serialVersionUID = 3710470335120544380L;
    private int id;
    @NotBlank(message = "Please, Enter theatre name. Theatre name should not be empty")
    private String theatreName;
    @NotBlank(message = "Please, Enter theatre city. Theatre location should not empty")
    private String theatreCity;
}
