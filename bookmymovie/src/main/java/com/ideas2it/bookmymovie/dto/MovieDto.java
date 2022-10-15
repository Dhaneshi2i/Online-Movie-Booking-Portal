package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MovieDto {

    private int movieId;

    private String name;

    private LocalDate releaseDate;

    private LocalTime duration;

    private List<ScreeningDto> screeningsDto = new ArrayList<>();

    private List<CastDto> castDto = new ArrayList<>();

    private List<LanguageDto> languagesDto = new ArrayList<>();

    private List<GenreDto> genresDto = new ArrayList<>();

}
