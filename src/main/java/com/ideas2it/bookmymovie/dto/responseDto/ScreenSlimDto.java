package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Component
public class ScreenSlimDto {
    private int screenId;
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String screenName;

}
