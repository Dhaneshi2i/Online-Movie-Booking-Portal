package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This TimeSlot repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {
    TimeSlot findByTimeSlotId(int timeSlotId);
}
