package com.ideas2it.bookmymovie.repository;

import com.ideas2it.bookmymovie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This Role repository save and retrieve data of booking in database.
 *
 * @author DhaneshKumar,Harini,SivaDharshini
 * @version 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleId(int roleId);

}
