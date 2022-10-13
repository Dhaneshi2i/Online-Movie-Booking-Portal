package com.ideas2it.bookmymovie.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private int id;

    private String name;

    private LocalDate releaseDate;

    private LocalTime duration;

    private List<ScreeningDto> screeningsDto = new ArrayList<>();

    private List<CastDto> castDto = new ArrayList<>();

    private List<LanguageDto> languagesDto = new ArrayList<>();

    private List<GenreDto> genresDto = new ArrayList<>();

}
