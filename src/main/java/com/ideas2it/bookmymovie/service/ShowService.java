package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ShowService {

    /**
     * <p>
     * This method is used to create Show Details
     * </p>
     *
     * @param showDto it contains show dto objects
     * @return ShowDto
     */
    List<ShowResponseDto> createShow(ShowDto showDto);

    /**
     * <p>
     * This method updates Show Details
     * </p>
     *
     * @param showDto it contains show dto objects
     * @return ShowDto
     */
    ShowDto updateShow(ShowDto showDto);

    /**
     * <p>
     * This method gets the Show Details with given id
     * </p>
     *
     * @param showId it contains show id
     * @return ShowDto
     */
    ShowDto getShowById(int showId);

    /**
     * <p>
     * This method List all the Show Details
     * </p>
     *
     * @return List<ShowDto>
     */
    List<ShowDto> getAllShow(int pageNumber, int pageSize);

    /**
     * <p>
     * This method List all the Screen Details by Theatre
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return List<ShowDto>
     */
    //List<ShowDto> getShowByTheatreId(int theatreId);

    /**
     * <p>
     * This method List all the Screen Details by Date
     * </p>
     *
     * @param date it contains date
     * @return List<ShowDto>
     */
    List<ShowDto> getShowsByDate(LocalDate date);

}
