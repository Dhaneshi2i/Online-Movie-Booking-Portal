package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class MovieSlimDto {
    @NotBlank(message = "Please, Enter the movie name.Movie field should not be empty")
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String movieName;
}
