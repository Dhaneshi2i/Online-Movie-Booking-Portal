package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    List<Theatre> findByCityName(String cityName);
    List<Theatre> findAllByStatus(Boolean status);
}
