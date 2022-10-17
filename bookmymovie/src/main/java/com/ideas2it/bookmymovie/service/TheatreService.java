package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;


/**
 * This an interface for theatre related business logic
 */
public interface TheatreService {
    /**
     * This method gets theatreDto object as parameter to create Theatre Details
     *
     * @param theatreDto is passed as argument to add these value to the database.
     */
    TheatreDto createTheatreDetails(TheatreDto theatreDto);

    /**
     * This method List all the Theatre Details that are present in Database
     *
     * @return List<TheatreDto> which will have all the Theatre Details which are present in
     * the database.
     */
    List<TheatreDto> listAllTheatre() throws NotFoundException;

    /**
     * This method gets TheatreDto as parameter and update the Theatre Details
     *
     * @param theatreId is passed as argument to update those value to the database.
     * @return String
     */
    TheatreDto updateTheatreStatusDetail(int theatreId,boolean status) throws NotFoundException;

    /**
     * This method List all the Theatre Details by City Name that are present in Database
     *
     * @param cityName is passed to categorize the theatre Details by City Name
     * @return List<TheatreDto> which will have the list of all the details of theatre
     * which was categorized by city name
     */
    List<TheatreDto> ListTheatreByCityName(String cityName) throws NotFoundException;
}
