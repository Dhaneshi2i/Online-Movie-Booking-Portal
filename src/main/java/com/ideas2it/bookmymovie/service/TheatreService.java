package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

public interface TheatreService {
    List<TheatreDto> getAllTheatres() throws NotFoundException;

    TheatreDto findTheatres(int theatreId);

    TheatreDto addTheatre(TheatreDto theatreDto) throws NotFoundException;

    List<TheatreDto> updateTheatreById(int theatreId );

    List<TheatreDto> deleteTheatreById(int theatreId);

    List<TheatreDto> findTheatresByMovie(int movieId) throws NotFoundException;

}
