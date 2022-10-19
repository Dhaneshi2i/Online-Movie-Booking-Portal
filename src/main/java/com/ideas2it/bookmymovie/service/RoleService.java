package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto saveRole(RoleDto roleDto);
    List<RoleDto> getAllRoles();
    RoleDto getRoleByRoleType(String roleType);
//    void deleteRole(int id);
}
