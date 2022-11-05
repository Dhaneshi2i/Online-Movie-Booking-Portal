package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This Screen repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    Screen findByScreenId(int screenId);
    List<Screen> findAllByStatus(boolean status);
}

