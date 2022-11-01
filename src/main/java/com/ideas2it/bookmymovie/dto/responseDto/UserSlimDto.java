package com.ideas2it.bookmymovie.dto.responseDto;

import com.ideas2it.bookmymovie.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserSlimDto {
    @NotBlank
    @Pattern(regexp = Constants.NAME_REGEX, message = "Only letter are valid")
    private String userName;
    @NotNull
    private long contactNumber;
    @NotNull
    @Email
    private String emailId;
    private RoleSlimDto role;
}
