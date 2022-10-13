package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;

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
     * @param theatreDto is passed as argument to update those value to the database.
     * @return String
     */
    String updateTheatreDetails(TheatreDto theatreDto);

    /**
     * This method List all the Theatre Details by City Name that are present in Database
     *
     * @param cityName is passed to categorize the theatre Details by City Name
     * @return List<TheatreDto> which will have the list of all the details of theatre
     * which was categorized by city name
     */
    List<TheatreDto> ListTheatreByCityName(String cityName) throws NotFoundException;

    /**
     * This method is to delete the Theatre Details by the given Theatre id
     *
     * @param theatreId is passed as parameter to get delete the particular Theatre Details
     * @return True if the Details are deleted and False if the Details are not Deleted
     */
    Boolean DeleteTheatre(int theatreId);
}
