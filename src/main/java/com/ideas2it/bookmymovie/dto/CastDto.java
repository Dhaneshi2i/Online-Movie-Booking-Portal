package com.ideas2it.bookmymovie.dto;

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
public class CastDto {
    private int castId;
    private String name;
    private String role;
    private List<MovieDto> movies = new ArrayList<>();
}
