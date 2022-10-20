package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.dto.responseDto.ScreenSlimDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private String theatreName;
    @NotNull
    private String theatreCity;

    private List<ScreenSlimDto> screen;

    private List<ShowSlimDto> show;

}
