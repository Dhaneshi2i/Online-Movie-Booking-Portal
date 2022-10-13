package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.model.Screen;

public class ScreenMapper {

    public ScreenDto convertScreenToScreenDto(Screen screen){
        ScreenDto screenDto = new ScreenDto();
        if(screen != null){
            if(screen.getScreenId() != 0){
                screenDto.setScreenId(screen.getScreenId());
            }
            screenDto.setNoOfSeats(screen.getNoOfSeats());
            screenDto.setNoOfRows(screen.getNoOfRows());
            screenDto.setNoOfColumns(screen.getNoOfColumns());
        }
        return screenDto;
    }
}
