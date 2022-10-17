package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findById(int id);
    Optional<Users> findByName(String name);
    List<Users> getAllUsersByStatus(boolean status);
    //Optional<List<Users>> getAllUsersByStatus(boolean status);

}

