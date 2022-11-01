package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ScreenSlimDto {
    private int screenId;
    private String screenName;

}
