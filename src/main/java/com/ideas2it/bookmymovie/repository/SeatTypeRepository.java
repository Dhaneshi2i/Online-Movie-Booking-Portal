package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This SeatType repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Integer> {

}
