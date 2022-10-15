package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface ScreenService {
    /**
     * This method gets ScreenDto object as parameter to create Screen Details
     *
     * @param screenDto is passed as argument to add these value to the database.
     */
    ScreenDto createScreenDetails(ScreenDto screenDto);

    /**
     * This method List all the Screen Details that are present in Database
     *
     * @return List<ScreenDto> which will have all the Screen Details which are present in
     * the database.
     */
    List<ScreenDto> listAllScreen() throws NotFoundException;

    /**
     * This method gets ScreenDto as parameter and update the Screen Details
     *
     * @param screenId is passed as argument to update those value to the database.
     * @return String
     */
    ScreenDto updateScreenStatusDetail(int screenId,Boolean status) throws NotFoundException;
}
