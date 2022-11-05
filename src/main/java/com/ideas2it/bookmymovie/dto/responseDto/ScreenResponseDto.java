package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * screen Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
public class ScreenResponseDto {

    private int id;

    private String screenName;

    private TheatreResponseDto theatre;
}