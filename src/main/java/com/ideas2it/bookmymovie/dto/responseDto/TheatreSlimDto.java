package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TheatreSlimDto {

    private int theatreId;
    private String theatreName;
    private String theatreCity;
}
