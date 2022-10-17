package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Theatre} entity
 */
@Setter
@Getter
@NoArgsConstructor
public class TheatreDto {
    private int theatreId;
    private String name;
    private String cityName;
    private List<ScreenDto> screens = new ArrayList<>();
}
