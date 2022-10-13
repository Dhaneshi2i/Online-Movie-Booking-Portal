package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedSeatRepository extends JpaRepository<BookedSeat,Integer> {
}
