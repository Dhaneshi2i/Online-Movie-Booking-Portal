package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Seat;

import java.util.List;

public interface SeatService {

    /**
     * <p>
     * This method is used to create Seat Details
     * </p>
     *
     * @param seat it contains seat objects
     */
     void createSeat(Seat seat) ;

    /**
     * <p>
     * This method List all the Seat Details
     * </p>
     *
     * @return List<SeatDto>
     */
     List<SeatDto> getAllSeat() throws NotFoundException;

     /**
     * <p>
     * This method updates the Seat Details
     * </p>
     *
     * @param seatId it contains seat id
     * @return SeatDto
     */
     SeatDto updateSeatById(int seatId) throws NotFoundException;


    /**
     * <p>
     * This method is used to book Seats
     * </p>
     *
     * @param seat it contains seat objects
     * @return SeatDto
     */
     Seat bookSeat(Seat seat);

    /**
     * <p>
     * This method is used to cancel Seats
     * </p>
     *
     * @param seat it contains seat objects
     * @return SeatDto
     */
    Seat cancelSeatBooking(Seat seat);

    /**
     * <p>
     * This method gets the Seat Details
     * </p>
     *
     * @param seatId it contains seat id
     * @return SeatDto
     */
    Seat getSeatBYId(int seatId);

    /**
     * <p>
     * This method List all the Seat Details with given showId
     * </p>
     *
     * @param showId it contains show id
     * @return List<SeatDto>
     */
    List<SeatDto> getSeatByShowId(int showId);

}
