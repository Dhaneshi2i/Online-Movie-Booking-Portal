package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDto {

    private int movieId;
    @NotBlank
    private String movieName;
    @NotNull(message = "Enter the movie duration in correct format")
    private LocalTime duration;
    @NotNull
    private LocalDate releaseDate;
    @NotEmpty(message = "cast is blank")
    private List<CastDto> casts = new ArrayList<>();
    @NotEmpty(message = "language is empty")
    private List<LanguageDto> languages = new ArrayList<>();
    @NotEmpty
    private List<GenreDto> genres = new ArrayList<>();

}
