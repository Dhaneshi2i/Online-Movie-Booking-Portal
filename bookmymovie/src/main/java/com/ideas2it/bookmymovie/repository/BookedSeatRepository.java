package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat,Integer> {
    BookedSeat findById(int id);
}
