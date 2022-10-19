package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.slimdto.ScreenSlimDto;
import com.ideas2it.bookmymovie.slimdto.ShowSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Theatre} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TheatreDto {

    private int theatreId;

    private String theatreName;

    private String theatreCity;

    private List<ScreenSlimDto> screen;

    private List<ShowSlimDto> show;

}
