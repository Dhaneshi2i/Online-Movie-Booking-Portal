package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This Show repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
public interface ShowRepository extends JpaRepository<Show, Integer> {
	Show findByShowId(int showId);

    boolean existsByShowDate(LocalDate showDate);

    boolean existsByShowStartTime(LocalTime showStartTime);

}
