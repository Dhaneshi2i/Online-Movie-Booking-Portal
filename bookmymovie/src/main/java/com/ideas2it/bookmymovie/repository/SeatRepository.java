package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {

    @Override
    Optional<Seat> findById(Integer integer);
}
