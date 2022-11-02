package com.ideas2it.bookmymovie.dto;


import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * <p>
 * Language Dto class contains the language dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
public class LanguageDto {

    private int languageId;
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Please, Enter valid language")
    private String languageName;

}
