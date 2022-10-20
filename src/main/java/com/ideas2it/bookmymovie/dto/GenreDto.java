package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.dto.responseDto.MovieSlimDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class GenreDto {
    private int genreId;

    private String name;

    private List<MovieSlimDto> movies = new ArrayList<>();

}
