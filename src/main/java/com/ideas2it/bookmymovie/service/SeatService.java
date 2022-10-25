package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Seat;

import java.util.List;

public interface SeatService {

    /**
     * This method gets seatDto object as parameter to create Seat Details
     *
     * @param seatDto is passed as argument to add these value to the database.
     * @return SeatDto which return the created Seat Details
     */
    public SeatDto createSeat(SeatDto seatDto) throws NotFoundException;

    /**
     * This method List all the Seat Details that are present in Database
     *
     * @return List<SeatDto> which will have all the Seat Details which are present in
     * the database.
     */
    public List<SeatDto> getAllSeat() throws NotFoundException;

    /**
     * This method gets seatId as parameter and update the Seat Details
     *
     * @param seatId is passed as argument to get those value from the database.
     * @return List of seat details after update
     */
    public SeatDto updateSeatById(int seatId) throws NotFoundException;


    /**
     * This method gets SeatDto object as parameter to create Seat Details
     *
     * @param seatDto is passed as argument to add these value to the database..
     * @return SeatDto which return the Seat Details with seat Status
     */
    public Seat bookSeat(Seat seat);
 
    /**
     * This method gets SeatDto object as parameter to create Seat Details
     *
     * @param seatDto is passed as argument to add these value to the database.
     * @return SeatDto which return the Seat Details with seat Status
     */
    public Seat cancelSeatBooking(Seat seat);
    Seat getSeatBYId(int seatId);

//    /**
//     * This method gets screenDto object as parameter to create Screen Details
//     *
//     * @param seatDto is passed as argument to add these value to the database.
//     * @return SeatDto which return the Seat Details with seat Status
//     */
//    public SeatDto blockSeat(SeatDto seatDto);

}
