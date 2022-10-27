package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    Optional<Seat> findBySeatNumberAndType(String seatNumber, String type);
    List<Seat> findBySeatStatus(SeatStatus seatStatus);
}
