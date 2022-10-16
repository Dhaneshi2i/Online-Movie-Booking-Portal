package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface RoleService {
    public RoleDto saveRole(RoleDto roleDto);
    public List<RoleDto> getAllRoles() throws NotFoundException;
//    public RoleDto getRoleById(int id) throws NotFoundException;

    RoleDto getRoleByName(String roleType) throws NotFoundException;
    void deleteRole(int id);
}
