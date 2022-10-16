package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findById(int id);
    Users findByName(String name);
    List<Users> getAllUsersByStatus(boolean status);

}

