package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private int noOfRows;
    @NotNull
    private int noOfColumns;
    private TheatreDto theatre;
    //private boolean status;

    //private List<ShowSlimDto> show;

}
