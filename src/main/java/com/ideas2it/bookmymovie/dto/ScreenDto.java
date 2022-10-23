package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screen} entity
 */
public class ScreenDto {
    private int screenId;
    @NotBlank
    private String screenName;
    @NotBlank
    private int noOfRows;
    @NotBlank
    private int noOfColumns;
    @NotBlank
    private TheatreDto theatre;
    //private boolean status;

    //private List<ShowSlimDto> show;

}
