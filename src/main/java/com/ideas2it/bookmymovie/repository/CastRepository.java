package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Cast, Integer> {
    boolean existsByCastName(String castName);
}
