package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * <p>
 * Screen Dto class contains the screen dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor

public class ScreenDto {

    private int screenId;
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Please, Enter valid screen name")
    private String screenName;
    private List<SeatTypeDto> typesOfSeats;
    private TheatreDto theatre;
}
