package com.ideas2it.bookmymovie.dto;


import com.ideas2it.bookmymovie.dto.responseDto.MovieSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    private int languageId;

    private String name;

    private List<MovieSlimDto> movies = new ArrayList<>();

}
