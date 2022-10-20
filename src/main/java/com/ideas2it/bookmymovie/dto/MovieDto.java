package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotNull
    private String movieName;
    @NotNull
    private LocalTime duration;
    @NotNull
    private List<CastDto> casts = new ArrayList<>();
    @NotNull
    private List<LanguageDto> languages = new ArrayList<>();
    @NotNull
    private List<GenreDto> genres = new ArrayList<>();
    @NotNull
    private LocalDate movieDate;
    //private ShowDto show;
}
