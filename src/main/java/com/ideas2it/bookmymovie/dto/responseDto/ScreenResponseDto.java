package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * <p>
 * screen Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@Component
public class ScreenResponseDto {
    private int screenId;
    private String screenName;

}