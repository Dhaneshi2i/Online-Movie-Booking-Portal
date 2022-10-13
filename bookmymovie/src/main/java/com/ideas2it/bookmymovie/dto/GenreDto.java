package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Movie;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {
    private int id;

    private String name;

    private List<MovieDto> moviesDto = new ArrayList<>();
}
