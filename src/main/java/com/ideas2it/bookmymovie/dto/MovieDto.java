package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Movie Dto class contains the movie dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class MovieDto {
    private int movieId;
    @NotBlank(message = "Please, Enter the movie name.Movie field should not be empty")
    @Pattern(regexp = Constants.NAME_REGEX, message = "Please, Enter valid movie name")
    private String movieName;
    @NotNull(message = "Please, Enter the movie duration in correct format(HH:mm)")
    private LocalTime duration;
    @NotNull(message = "Please, Enter the movie release date.Release date field should not be empty")
    private LocalDate releaseDate;
    @NotEmpty(message = "Please, Enter the movie's cast.Cast field should not be empty")
    private List<CastDto> casts = new ArrayList<>();
    @NotEmpty(message = "Please, Enter the movie's language.Language field should not be empty")
    private List<LanguageDto> languages = new ArrayList<>();
    @NotEmpty(message = "Please, Enter the movie's genre.Genre field should not be empty")
    private List<GenreDto> genres = new ArrayList<>();

}
