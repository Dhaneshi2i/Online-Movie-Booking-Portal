package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
}
