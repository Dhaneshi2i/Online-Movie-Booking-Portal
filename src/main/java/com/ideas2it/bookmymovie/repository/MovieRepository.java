package com.ideas2it.bookmymovie.repository;


import com.ideas2it.bookmymovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This Movie repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieId(int movieId);
}
