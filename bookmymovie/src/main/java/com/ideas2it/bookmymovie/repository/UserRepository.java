package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
