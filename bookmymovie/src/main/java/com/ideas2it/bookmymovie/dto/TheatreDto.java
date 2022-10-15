package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Theatre} entity
 */
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TheatreDto {
    private int theatreId;
    private String name;
    private String cityName;
    private List<ScreenDto> screens = new ArrayList<>();
}
