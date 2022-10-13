package com.ideas2it.bookmymovie.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Theatre} entity
 */
@Data
public class TheatreDto {
    private int theatreId;
    private String name;
    private String cityName;
    private List<ScreenDto> screensDto = new ArrayList<>();
}
