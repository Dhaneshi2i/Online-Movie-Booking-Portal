package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Cast;
import com.ideas2it.bookmymovie.model.Genre;
import com.ideas2it.bookmymovie.model.Language;
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

    private String movieName;

    private List<CastDto> casts = new ArrayList<>();

    private List<LanguageDto> languages = new ArrayList<>();

    private List<GenreDto> genres = new ArrayList<>();
    private LocalDate movieDate;
    private ShowDto show;

}
