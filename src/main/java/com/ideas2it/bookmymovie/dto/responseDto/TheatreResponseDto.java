package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Theatre Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
public class TheatreResponseDto {
    private int theatreId;
    private String theatreName;
    private String theatreCity;
}
