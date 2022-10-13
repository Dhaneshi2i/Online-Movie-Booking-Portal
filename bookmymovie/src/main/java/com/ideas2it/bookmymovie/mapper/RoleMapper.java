package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.model.Role;

import java.util.stream.Collectors;

public class RoleMapper {

    private UserMapper userMapper;
    private Role role;
    private RoleDto roleDto;

    public RoleMapper(Role role) {
        this.role = role;
    }

    public RoleMapper(RoleDto roleDto) {
        this.roleDto = roleDto;
    }

    public RoleMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Role convertRoleDtoToRole(RoleDto roleDto) {
        if (roleDto != null) {
            role.setRoleId(roleDto.getRoleId());
            role.setRoleType(roleDto.getRoleType());
            role.setUsers(roleDto.getUsers().stream().map(usersDto -> userMapper.convertUsersDtoToUsers(usersDto))
                    .collect(Collectors.toList()));
        }
        return role;
    }

    public RoleDto convertRoleToRoleDto(Role role) {
        if (role != null) {
            roleDto.setRoleId(role.getRoleId());
            roleDto.setRoleType(role.getRoleType());
            roleDto.setUsers(role.getUsers().stream().map(users -> userMapper.convertUsersToUsersDto(users))
                    .collect(Collectors.toList()));
        }
        return roleDto;
    }
}
