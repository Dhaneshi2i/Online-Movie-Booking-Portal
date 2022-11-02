package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * <p>
 * Genre Dto class contains the genre dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class GenreDto {

    private int genreId;
    @NotBlank(message = "Genre should not be empty")
    @Pattern(regexp="^(Action|Thriller|Drama)$",message="Invalid genre. Valid values are 1. Action 2. Thriller 3.Drama")
    private String genreName;
}
