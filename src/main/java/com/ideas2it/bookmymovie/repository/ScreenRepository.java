package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    List<Screen> findAllByStatus(Boolean status);
}

