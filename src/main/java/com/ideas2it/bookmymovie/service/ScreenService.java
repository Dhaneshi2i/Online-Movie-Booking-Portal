package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowResponseDto;

import java.util.List;

/**
 * <p>
 * This {@Code ScreenService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
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
     * <p>
     * This method List all the screen details by theatre that are present in Database
     * </p>
     *
     * @param theatreId is passed to categorize the screen Details by Movie
     * @return List<ScreenResponseDto>
     */
    List<ScreenResponseDto> getScreenByTheatreId(int theatreId);

    /**
     * <p>
     * This method List all the shows Details for the screen
     * </p>
     *
     * @param screenId it contains date
     * @return List<ShowResponseDto>
     */
    List<ShowResponseDto> getShowByScreenId(int screenId);
}
