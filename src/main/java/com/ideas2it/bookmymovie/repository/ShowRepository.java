package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {
	@Query("select s from Show s where s.theatre.theatreId = :id")
	List<Show> getAllByTheatreId(@Param("id") int id);
}
