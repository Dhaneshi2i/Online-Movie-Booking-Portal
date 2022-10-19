package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CastRepository extends JpaRepository<Cast, Integer> {

    Optional<Cast> findCastByName(String name);
}