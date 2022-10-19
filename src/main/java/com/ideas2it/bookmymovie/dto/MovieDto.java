package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MovieDto {

    private int movieId;

    private String name;

    private ZonedDateTime releaseDate;

    private String duration;

    private List<CastDto> casts = new ArrayList<>();

    private List<LanguageDto> languages = new ArrayList<>();

    private List<GenreDto> genres = new ArrayList<>();

    private Boolean Status;

    private LocalDate createdDate;

    private LocalDate modifiedDate;
}
