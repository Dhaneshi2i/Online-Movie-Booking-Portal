package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.UsersDto;
import com.ideas2it.bookmymovie.model.Users;

public class UserMapper {

    private RoleMapper roleMapper;
    private Users users;

    private UsersDto usersDto;
    public UserMapper(Users users) {
        this.users = users;
    }

    public UserMapper(UsersDto usersDto) {
        this.usersDto = usersDto;
    }

    public UserMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public Users convertUsersDtoToUsers(UsersDto usersDto) {
        if (usersDto != null) {
            users.setUserId(usersDto.getUserId());
            users.setName(usersDto.getName());
            users.setEmailId(usersDto.getEmailId());
            users.setContactNumber(usersDto.getContactNumber());
            users.setRole(roleMapper.convertRoleDtoToRole(usersDto.getRole()));
        }
        return users;
    }

    public UsersDto convertUsersToUsersDto(Users users) {
        if (users != null) {
            usersDto.setUserId(users.getUserId());
            usersDto.setName(users.getName());
            usersDto.setEmailId(users.getEmailId());
            usersDto.setContactNumber(users.getContactNumber());
            usersDto.setRole(roleMapper.convertRoleToRoleDto(users.getRole()));

        }
        return usersDto;
    }
}
