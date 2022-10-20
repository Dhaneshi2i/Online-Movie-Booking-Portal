package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.dto.responseDto.RoleSlimDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    List<RoleDto> getAllRoles();
    RoleSlimDto getRoleByRoleType(String roleType);
//    void deleteRole(int id);
}
