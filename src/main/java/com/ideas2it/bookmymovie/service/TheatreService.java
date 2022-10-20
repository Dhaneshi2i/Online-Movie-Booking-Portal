package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.responseDto.TheatreSlimDto;
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
    TheatreDto createTheatre(TheatreDto theatreDto) throws NotFoundException;

    /**
     * This method List all the Theatre Details that are present in Database
     *
     * @return List<TheatreDto> which will have all the Theatre Details which are present in
     * the database.
     */
    List<TheatreDto> getAllTheatre() throws NotFoundException;

    /**
     * This method gets TheatreId as parameter and get the Theatre Details which matches the id
     *
     * @param theatreId is passed as argument to fetch those from the database.
     * @return TheatreDto which is fetched from database with the param
     */
    TheatreSlimDto findTheatreById(int theatreId);

    /**
     * This method gets TheatreId as parameter and update the Theatre Details
     *
     * @param theatreId is passed as argument to get those value from the database.
     * @return List of theatre details after update
     */
    List<TheatreDto> updateTheatreById(int theatreId );

    /**
     * This method gets TheatreId as parameter and delete the Theatre Details with the given id
     *
     * @param theatreId is passed as argument to delete those value from the database.
     * @return List of theatre details after deletion
     */
    List<TheatreDto> deleteTheatreById(int theatreId);

    /**
     * This method List all the Theatre Details by movie that are present in Database
     *
     * @param movieId is passed to categorize the theatre Details by Movie
     * @return List<TheatreDto> which will have the list of all the details of theatre
     * which was categorized by movie
     */
    List<TheatreDto> findTheatresByMovieId(int movieId) throws NotFoundException;

}
