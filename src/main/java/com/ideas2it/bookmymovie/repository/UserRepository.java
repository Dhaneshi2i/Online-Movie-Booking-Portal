package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This User repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
    boolean existsByContactNumber(String contactNumber);
    boolean existsByUserName(String userName);
}
