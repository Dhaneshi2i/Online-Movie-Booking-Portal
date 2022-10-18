package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.exception.TheatreNotFoundException;

import java.math.BigDecimal;
import java.util.List;


/**
 * This an interface for theatre related business logic
 */
public interface TheatreService {

    /**
     * This method List all the Theatre Details that are present in Database
     *
     * @return List<TheatreDto> which will have all the Theatre Details which are present in
     * the database.
     */
    public List<TheatreDto> getAllTheatres() throws TheatreNotFoundException;

    public TheatreDto findTheatres(int theatreId);

    /**
     * This method gets theatreDto object as parameter to create Theatre Details
     *
     * @param theatreDto is passed as argument to add these value to the database.
     */
    public TheatreDto addTheatre(TheatreDto theatreDto) throws TheatreNotFoundException;

    public List<TheatreDto> updateTheatre(BigDecimal theatreId, TheatreDto theatreDto);

    public List<TheatreDto> deleteTheatreById(BigDecimal theatreId);

    public List<TheatreDto> findTheatresByMovie(BigDecimal movieId) throws TheatreNotFoundException;
}
