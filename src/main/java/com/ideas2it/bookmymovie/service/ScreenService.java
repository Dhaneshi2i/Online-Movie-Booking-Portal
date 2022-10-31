package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

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
    ScreenDto createScreen(ScreenDto screenDto) throws NotFoundException;

    /**
     * <p>
     * This method List all the Screen Details
     * </p>
     *
     * @return List<ScreenDto>
     */
    List<ScreenDto> getAllScreen() throws NotFoundException;

    /**
     * <p>
     * This method updates the Screen Details
     * </p>
     *
     * @param screenId it contains
     * @return ScreenDto
     */
    ScreenDto updateScreenById(int screenId)  throws NotFoundException;

    /**
     * <p>
     * This method List all the Theatre Details by screen
     * </p>
     *
     * @param screenId it contains screen id
     * @return TheatreDto
     */
    ScreenDto getScreenById(int screenId) throws NotFoundException;

    /**
     * This method List all the Theatre Details by screen that are present in Database
     *
     * @param screenId is passed to categorize the screen Details by Movie
     * @return TheatreDto which will have the details of theatre
     * which was categorized by screen
     */
    TheatreDto getTheatreByScreenId(int screenId) throws NotFoundException;
}
