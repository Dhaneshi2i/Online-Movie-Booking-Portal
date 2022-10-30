package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
    Theatre findByTheatreId(int theatreId);
    List<Theatre> findAllByStatus(Boolean status);
    List<Theatre> findTheatreByTheatreCity(String cityName);
}
