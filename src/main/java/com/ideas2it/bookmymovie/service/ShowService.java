package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.responseDto.SeatResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowResponseDto;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * This {@Code ShowService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface ShowService {

    /**
     * <p>
     * This method is used to create Show Details
     * </p>
     *
     * @param showDto it contains show dto objects
     * @return List<ShowResponseDto>
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
     * @return ShowResponseDto
     */
    ShowResponseDto getShowById(int showId);

    /**
     * <p>
     * This method List all the Show Details
     * </p>
     *
     * @return List<ShowDto>
     */
    List<ShowResponseDto> getAllShow(int pageNumber, int pageSize);

    /**
     * <p>
     * This method List all the Shows Details by Date
     * </p>
     *
     * @param date it contains date
     * @return List<ShowResponseDto>
     */
    List<ShowResponseDto> getShowsByDate(LocalDate date);

    /**
     * <p>
     * This method List all the shows Details for the screen
     * </p>
     *
     * @param screenId it contains date
     * @return List<ShowResponseDto>
     */
    List<ShowResponseDto> getShowByScreenId(int screenId);

    /**
     * <p>
     * This method List all the Seat Details with given showId
     * </p>
     *
     * @param showId it contains show id
     * @return List<SeatDto>
     */
    List<SeatResponseDto> getSeatByShowId(int showId);
}
