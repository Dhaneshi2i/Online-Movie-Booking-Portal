package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.TheatreNotFoundException;

import java.util.List;

public interface TheatreService {
    List<TheatreDto> getAllTheatres() throws TheatreNotFoundException;

    TheatreDto findTheatres(int theatreId);

    TheatreDto addTheatre(TheatreDto t) throws TheatreNotFoundException;

    List<TheatreDto> updateTheatre(int theatreId );

    List<TheatreDto> deleteTheatreById(int theatreId);

//    List<TheatreDto> findTheatresByMovie(BigDecimal movieId) throws TheatreNotFoundException;

}
