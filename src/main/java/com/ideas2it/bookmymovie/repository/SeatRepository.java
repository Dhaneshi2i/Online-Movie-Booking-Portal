package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {

    Boolean findBySeatNumberAndType(String seatNumber, String type);

    List<Seat> findBySeatStatus(String seatStatus);
}
