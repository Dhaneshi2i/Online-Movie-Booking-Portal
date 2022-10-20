package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.ScreenNotFoundException;

import java.util.List;

public interface ScreenService {
    public ScreenDto addScreen(ScreenDto screenDto, int theatreId) throws ScreenNotFoundException;
    public List<ScreenDto> viewScreenList() throws ScreenNotFoundException;
    public ScreenDto updateScreen(int screenId);
    public ScreenDto viewScreen(int screenId) throws ScreenNotFoundException;
    public TheatreDto getTheatre(int screenId) throws ScreenNotFoundException;
}
