package com.ideas2it.bookmymovie.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScreenSlimDto {
    private String screenName;
    private int noOfRows;
    private int noOfColumns;
}
