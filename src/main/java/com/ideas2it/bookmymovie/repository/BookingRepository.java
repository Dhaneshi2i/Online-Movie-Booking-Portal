package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This booking repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    Booking findBookingByBookingId(int bookingId);

}
