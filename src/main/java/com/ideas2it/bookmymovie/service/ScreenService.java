package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenSlimDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

/**
 * This an interface for Screen related business logic
 */
public interface ScreenService {

    /**
     * This method gets screenDto object as parameter to create Screen Details
     *
     * @param screenDto is passed as argument to add these value to the database.
     *
     * @return ScreenDto which return the created Screen Details
     */
    ScreenDto createScreen(ScreenDto screenDto, int theatreId) throws NotFoundException;

    /**
     * This method List all the Screen Details that are present in Database
     *
     * @return List<ScreenDto> which will have all the Screen Details which are present in
     * the database.
     */

    List<ScreenDto> getAllScreen() throws NotFoundException;

    /**
     * This method gets screenId as parameter and update the Screen Details
     *
     * @param screenId is passed as argument to get those value from the database.
     * @return List of screen details after update
     */
    ScreenDto updateScreenById(int screenId)  throws NotFoundException;

    /**
     * This method gets screenId as parameter and get the Screen Details which matches the id
     *
     * @param screenId is passed as argument to fetch those from the database.
     * @return ScreenDto which is fetched from database with the param
     */
    ScreenSlimDto getScreenById(int screenId) throws NotFoundException;

    /**
     * This method List all the Theatre Details by screen that are present in Database
     *
     * @param screenId is passed to categorize the screen Details by Movie
     * @return TheatreDto which will have the details of theatre
     * which was categorized by screen
     */
    TheatreDto getTheatreByScreenId(int screenId) throws NotFoundException;
}
