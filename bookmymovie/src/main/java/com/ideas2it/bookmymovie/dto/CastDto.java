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
@AllArgsConstructor
@NoArgsConstructor
public class CastDto {
    private int id;

    private String name;

    private String role;

    private List<MovieDto> moviesDto = new ArrayList<>();
}
