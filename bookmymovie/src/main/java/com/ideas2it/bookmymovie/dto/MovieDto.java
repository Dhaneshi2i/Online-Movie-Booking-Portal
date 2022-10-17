package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "movieId")
public class MovieDto {

    private int movieId;

    private String name;

    private LocalDate releaseDate;

    private String duration;

    private List<ScreeningDto> screenings = new ArrayList<>();

    private List<CastDto> casts = new ArrayList<>();

    private List<LanguageDto> languages = new ArrayList<>();

    private List<GenreDto> genres = new ArrayList<>();

    private Boolean Status;

    private LocalDate createdDate;

    private LocalDate modifiedDate;
}
