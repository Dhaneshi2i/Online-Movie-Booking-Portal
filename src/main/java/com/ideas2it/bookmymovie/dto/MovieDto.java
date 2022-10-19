package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private int movieId;
    private String movieName;
    private String duration;
    private List<CastDto> casts = new ArrayList<>();
    private List<LanguageDto> languages = new ArrayList<>();
    private List<GenreDto> genres = new ArrayList<>();
    private String movieRating;
    private LocalDate movieDate;
    private ShowDto show;

}
