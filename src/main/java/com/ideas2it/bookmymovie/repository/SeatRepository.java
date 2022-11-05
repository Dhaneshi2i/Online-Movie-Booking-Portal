package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This Seat repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    Seat findBySeatId(int seat);
    List<Seat> findBySeatStatus(SeatStatus seatStatus);

}
