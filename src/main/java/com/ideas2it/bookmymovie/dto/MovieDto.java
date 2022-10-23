package com.ideas2it.bookmymovie.dto;

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
public class MovieDto {

    private int movieId;
    @NotBlank
    private String movieName;
    @NotNull(message = "Enter the movie duration in correct format")
    private LocalTime duration;
    @NotEmpty(message = "cast is blank")
    private List<CastDto> casts = new ArrayList<>();
    @NotEmpty(message = "language is empty")
    private List<LanguageDto> languages = new ArrayList<>();
    @NotEmpty
    private List<GenreDto> genres = new ArrayList<>();
    @NotNull
    private LocalDate releaseDate;
    //private ShowDto show;
}
