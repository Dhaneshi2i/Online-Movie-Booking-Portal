package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Booking, Integer> {
}