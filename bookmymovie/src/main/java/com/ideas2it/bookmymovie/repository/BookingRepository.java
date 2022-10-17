package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    @Override
    Optional<Booking> findById(Integer id);
}
