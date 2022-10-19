package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.slimdto.ShowSlimDto;
import com.ideas2it.bookmymovie.slimdto.TheatreSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screen} entity
 */
public class ScreenDto {
    private int screenId;

    private TheatreSlimDto theatre;

    private List<ShowSlimDto> show;

    private String screenName;

    private int rows;

    private int columns;
    private boolean status;
}
