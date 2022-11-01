package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class RoleSlimDto {
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String roleType;
}
