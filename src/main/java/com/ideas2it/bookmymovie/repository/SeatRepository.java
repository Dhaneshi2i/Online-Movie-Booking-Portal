package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    Seat findBySeatId(int seat);
    List<Seat> findBySeatStatus(SeatStatus seatStatus);
    List<Seat> findByShow(Show show);

}
