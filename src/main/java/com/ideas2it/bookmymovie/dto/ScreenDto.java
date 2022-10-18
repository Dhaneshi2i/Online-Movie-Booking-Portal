package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.slimdto.TheatreSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screen} entity
 */
public class ScreenDto {
//screendto
    private int screenId;

    private TheatreDto theatre;

    private List<ShowDto> show;

    private String screenName;

    private int rows;

    private int columns;
}
