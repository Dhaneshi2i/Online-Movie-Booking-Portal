package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieDto {

    private int movieId;

    private String name;

    private LocalDate releaseDate;

    private String duration;

    private List<ScreeningDto> screenings = new ArrayList<>();

    private List<CastDto> cast = new ArrayList<>();

    private List<LanguageDto> languages = new ArrayList<>();

    private List<GenreDto> genres = new ArrayList<>();

    private Boolean Status;

    private LocalDate createdDate;

    private LocalDate modifiedDate;
}
