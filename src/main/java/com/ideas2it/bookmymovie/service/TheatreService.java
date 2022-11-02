package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;


/**
 * This an interface for theatre related business logic
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
    TheatreDto createTheatre(TheatreDto theatreDto) throws NotFoundException;

    /**
     * <p>
     * This method List all the Theatre Details
     * </p>
     *
     * @return List<TheatreDto>
     */
    List<TheatreDto> getAllTheatre() throws NotFoundException;

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
     * @param theatreId it contains theatre id
     * @return List<TheatreDto>
     */
    List<TheatreDto> updateTheatreById(int theatreId );

    /**
     * <p>
     * This method delete the Theatre Details with the given id
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return List<TheatreDto>
     */
    List<TheatreDto> deleteTheatreById(int theatreId);

    /**
     * <p>
     * This method List all the Theatre Details by city name
     * </p>
     *
     * @param city it contains city
     * @return List<TheatreDto>
     */
    List<TheatreDto> findTheatresByLocation(String city) throws NotFoundException;
}
