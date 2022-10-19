package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {



}


