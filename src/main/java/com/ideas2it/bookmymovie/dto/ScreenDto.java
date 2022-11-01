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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDto {

    private int screenId;
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String screenName;
    private List<SeatTypeDto> typesOfSeats;
    private TheatreDto theatre;
}
