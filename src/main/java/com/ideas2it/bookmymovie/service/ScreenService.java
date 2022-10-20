package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.ScreenNotFoundException;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.exception.NotFoundException;


import java.util.List;

public interface ScreenService {
    public ScreenDto addScreen(ScreenDto screenDto, int theatreId) throws NotFoundException;
    public List<ScreenDto> viewScreenList() throws NotFoundException;
    public ScreenDto updateScreen(int screenId);

    public ScreenDto viewScreen(int screenId) throws NotFoundException;
    public TheatreDto getTheatre(int screenId) throws NotFoundException;
}
