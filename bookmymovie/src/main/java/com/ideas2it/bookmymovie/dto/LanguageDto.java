package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LanguageDto {
    private int languageId;

    private String name;

    private List<MovieDto> moviesDto = new ArrayList<>();
}
