package com.ideas2it.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Theatre} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreDto {
    private int theatreId;
    @NotBlank(message = "Theatre name should not be empty")
    private String theatreName;
    @NotBlank(message = "Theatre location should not empty")
    private String theatreCity;
}
