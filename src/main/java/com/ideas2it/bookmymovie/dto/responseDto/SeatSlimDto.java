package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.Constants;
import com.ideas2it.bookmymovie.model.SeatStatus;
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
public class SeatSlimDto {
    @NotBlank
    @Pattern(regexp = Constants.ALPHA_NUMERIC_REGEX, message = "Only letter are valid")
    private String seatNumber;

    @NotNull
    private double price;

    @NotNull
    private SeatStatus seatStatus;
}
