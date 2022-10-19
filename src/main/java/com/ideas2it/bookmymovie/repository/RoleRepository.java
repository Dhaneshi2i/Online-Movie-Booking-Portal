package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findUserByRoleType(String roleType);
}
