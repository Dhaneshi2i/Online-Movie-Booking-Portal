package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> getAllBymovieDate(LocalDate date);

}

