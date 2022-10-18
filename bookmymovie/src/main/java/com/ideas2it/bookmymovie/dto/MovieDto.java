package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Cast;
import com.ideas2it.bookmymovie.model.Genre;
import com.ideas2it.bookmymovie.model.Language;
import com.ideas2it.bookmymovie.model.Show;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private BigDecimal movieId;
    private String movieName;
    private List<GenreDto> genres = new ArrayList<>();
    private List<LanguageDto> languages = new ArrayList<>();
    private List<CastDto> casts =  new ArrayList<>();
    private LocalDate movieDate;
    private Show show;

}
