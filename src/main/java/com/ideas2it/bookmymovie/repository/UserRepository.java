package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByStatus(boolean status);
}
