package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Theatre;

import java.util.ArrayList;
import java.util.List;

public class TheatreMapper {
    public TheatreDto theatreToTheatreDto(Theatre theatre){
        TheatreDto theatreDto = new TheatreDto();
        if(theatre != null){
            if(theatre.getTheatreId() != 0){
                theatreDto.setTheatreId(theatre.getTheatreId());
            }
            theatreDto.setName(theatre.getName());
            theatreDto.setCityName(theatre.getCityName());
            List<Screen> screens = theatre.getScreens();
            List<ScreenDto> screensDto = new ArrayList<>();
            for (Screen screen : screens){
                ScreenDto screenDto = new ScreenDto();
                if(screen != null) {
                    if(screen.getScreenId() != 0){
                        screenDto.setScreenId(screen.getScreenId());
                    }
                    screenDto.setNoOfSeats(screen.getNoOfSeats());
                    screenDto.setNoOfRows(screen.getNoOfRows());
                    screenDto.setNoOfColumns(screen.getNoOfColumns());
                }
                screensDto.add(screenDto);
            }
            theatreDto.setScreensDto(screensDto);
        }
        return theatreDto;
    }

    public Theatre theatreDtoToTheatre(TheatreDto theatreDto){
        Theatre theatre = new Theatre();
        if(theatreDto != null){
            if(theatreDto.getTheatreId() != 0){
                theatre.setTheatreId(theatreDto.getTheatreId());
            }
            theatre.setName(theatreDto.getName());
            theatre.setCityName(theatreDto.getCityName());
            List<ScreenDto> screensDto = theatreDto.getScreensDto();
            List<Screen> screens = new ArrayList<>();
            for (ScreenDto screenDto : screensDto){
                Screen screen = new Screen();
                if(screenDto != null) {
                    if(screenDto.getScreenId() != 0){
                        screen.setScreenId(screenDto.getScreenId());
                    }
                    screen.setNoOfSeats(screenDto.getNoOfSeats());
                    screen.setNoOfRows(screenDto.getNoOfRows());
                    screen.setNoOfColumns(screenDto.getNoOfColumns());
                }
                screens.add(screen);
            }
            theatre.setScreens(screens);
        }
        return theatre;
    }
}
