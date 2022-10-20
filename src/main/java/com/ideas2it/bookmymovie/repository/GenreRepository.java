package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findGenreByName(String name);

}
