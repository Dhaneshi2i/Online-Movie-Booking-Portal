package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Screen} entity
 */
public class ScreenDto {
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String screenName;
    @NotNull
    private int noOfRows;
    @NotNull
    private int noOfColumns;
    @NotNull
    private TheatreDto theatre;

}
