package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private int genreId;
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String name;

}
