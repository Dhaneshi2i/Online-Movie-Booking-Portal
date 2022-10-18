package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    Optional<Booking> findByBookingId(String bookingId);

    @Modifying
    @Query(value = "UPDATE booking SET status = 1 WHERE bookingId = ?1",nativeQuery = true)
    Optional<Booking> updateBookingStatus(String bookingId, boolean status);

    @Modifying
    @Query(value = "UPDATE screen_seat SET reserved = 1 WHERE showId = ?1 and seat_number in ?2",nativeQuery = true)
    Optional<Booking> reserveSeat(String bookingId, List<String> seatNo);

    Optional<Booking> cancelTicket(Booking booking);

    /*@Modifying
    @Query(value = "UPDATE screen_seat SET status = 0,bookingId = NULL WHERE bookingId = ?1",nativeQuery = true)
    void cancelTicket(String bookingId);*/

    @Modifying
    @Query(value = "UPDATE booking SET payment_status = 1 WHERE bookingId= ?1",nativeQuery = true)
    void setPaymentStatus(String bookingId);

    /*@Modifying//Update/Delete queries must be annotated with @Modifying, otherwise an InvalidDataAccessApiUsageException will be thrown.
    @Query(value = "UPDATE screen_seat SET status = 1,bookingId = ?3 WHERE screeningId = ?1 and seat_number in ?2",nativeQuery = true)
    Optional<Booking> bookSeat(int screeningId, List<String> seatNo, String bookingId);*/

    //@Query(value = "select reserved from screen_seat where showId = ?1 and seat_number in ?2",nativeQuery = true)
    //List<Object> checkIsReserved(String showId,List<String> seatNo);

    /*@Query(value = "Select price from screen_seat where showId=?1 and seat_number in ?2",nativeQuery = true)
    List<Object> getPrice(String showId, List<String> seatNo);*/

}
