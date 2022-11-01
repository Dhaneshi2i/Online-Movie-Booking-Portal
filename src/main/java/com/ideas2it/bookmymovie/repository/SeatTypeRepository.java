package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Integer> {
    SeatType findBySeatTypeId(int seatTypeId);

}
