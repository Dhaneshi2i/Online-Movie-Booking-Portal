package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {
	Show findByShowId(int showId);
    List<Show> findAllByStatus(boolean status);
}
