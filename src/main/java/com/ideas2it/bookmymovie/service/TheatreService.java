package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.TheatreResponseDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;


/**
 * <p>
 * This {@Code TheatreService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface TheatreService {

    /**
     * <p>
     * This method is used to create Theatre Details
     * </p>
     *
     * @param theatreDto it contains theatre dto object
     * @return TheatreDto
     */
    TheatreResponseDto createTheatre(TheatreDto theatreDto) throws NotFoundException;

    /**
     * <p>
     * This method List all the Theatre Details
     * </p>
     *
     * @return List<TheatreDto>
     */
    List<TheatreDto> getAllTheatre(int pageNumber, int pageSize) throws NotFoundException;

    /**
     * <p>
     * This method gets the Theatre Details which matches the id
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return TheatreDto
     */
    TheatreDto findTheatreById(int theatreId);

    /**
     * <p>
     * This method update the Theatre Details
     * </p>
     *
     * @param theatreDto it contains theatre details
     * @return List<TheatreDto>
     */
    TheatreDto updateTheatre(TheatreDto theatreDto );

    /**
     * <p>
     * This method List all the Theatre Details by city name
     * </p>
     *
     * @param city it contains city
     * @return List<TheatreDto>
     */
    List<TheatreDto> findTheatresByLocation(String city) ;

    /**
     * <p>
     * This methods list all the screens for the theatre
     * </p>
     * @param theatreId it contains theatreId
     * @return List<ScreenResponseDto>
     */
    List<ScreenResponseDto> getScreenByTheatreId(int theatreId);
}
