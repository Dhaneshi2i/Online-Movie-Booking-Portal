package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSlimDto {
    private int userId;
    private String name;
    private long contactNumber;
    private String emailId;
}