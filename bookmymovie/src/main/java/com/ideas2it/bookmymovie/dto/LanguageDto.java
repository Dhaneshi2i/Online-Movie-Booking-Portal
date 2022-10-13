package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Movie;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {
    private int id;

    private String name;

    private List<MovieDto> moviesDto = new ArrayList<>();
}
