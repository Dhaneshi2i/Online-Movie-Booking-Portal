package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.model.Role;

import java.util.List;

/**
 * <p>
 * This {@Code RoleService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface RoleService {

    /**
     * <p>
     * This method is used to create Role Details
     * </p>
     *
     * @param roleDto it contains role dto objects
     * @return RoleDto
     */
    RoleDto createRole(RoleDto roleDto);

    /**
     * <p>
     * This method List all the Role Details
     * </p>
     *
     * @return List<RoleDto>
     */
    List<RoleDto> getAllRoles();

    /**
     * <p>
     * This method gets Role Details which matches the role type
     * </p>
     *
     * @param roleId it contains role type
     * @return Role
     */
    Role getRoleByRoleId(int roleId);
}
