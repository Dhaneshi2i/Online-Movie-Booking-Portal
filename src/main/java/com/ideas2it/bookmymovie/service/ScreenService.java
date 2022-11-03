package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenResponseDto;

import java.util.List;

/**
 * This an interface for Screen related business logic
 */
public interface ScreenService {

    /**
     * <p>
     * This method is used to create Screen Details
     * </p>
     *
     * @param screenDto it contains screen dto object
     * @return ScreenDto
     */
    ScreenDto createScreen(ScreenDto screenDto) ;

    /**
     * <p>
     * This method List all the Screen Details
     * </p>
     *
     * @return List<ScreenDto>
     */
    List<ScreenDto> getAllScreen();

    /**
     * <p>
     * This method updates the Screen Details
     * </p>
     *
     * @param screenDto it contains
     * @return ScreenDto
     */
    ScreenDto updateScreen(ScreenDto screenDto);

    /**
     * <p>
     * This method List all the Theatre Details by screen
     * </p>
     *
     * @param screenId it contains screen id
     * @return TheatreDto
     */
    ScreenDto getScreenById(int screenId) ;

    /**
     * This method List all the screen details by theatre that are present in Database
     *
     * @param theatreId is passed to categorize the screen Details by Movie
     * @return ScreenResponseDto which will have the details of theatre
     * which was categorized by screen
     */
    List<ScreenResponseDto> getScreenByTheatreId(int theatreId);

}
