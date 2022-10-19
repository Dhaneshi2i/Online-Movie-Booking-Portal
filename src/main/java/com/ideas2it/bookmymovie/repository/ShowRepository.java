package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
