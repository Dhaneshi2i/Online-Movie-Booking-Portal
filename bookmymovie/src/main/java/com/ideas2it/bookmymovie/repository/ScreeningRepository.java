package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening,Integer> {
}
