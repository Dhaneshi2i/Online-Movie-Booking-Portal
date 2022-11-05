package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This Genre repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByGenreId(int genreId);

    boolean existsByGenreName(String genreName);
}
