package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    Seat findById(int id);
}
