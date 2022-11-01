package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import com.ideas2it.bookmymovie.model.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

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
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String screenName;
    private List<SeatTypeDto> typesOfSeats;
    private TheatreDto theatre;
}
