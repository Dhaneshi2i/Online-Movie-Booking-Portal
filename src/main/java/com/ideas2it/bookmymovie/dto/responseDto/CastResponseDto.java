package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * <p>
 * Cast Response Dto class contains the required data to display.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class CastResponseDto {

    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Please, Enter valid name")
    private String castName;
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Please, Enter valid user role")
    private String castRole;

}
