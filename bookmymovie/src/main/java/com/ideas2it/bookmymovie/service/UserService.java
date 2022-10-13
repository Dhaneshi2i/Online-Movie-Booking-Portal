package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.UsersDto;

import java.util.List;

public interface UserService {
    void createUser(UsersDto usersDto);
    public List<UsersDto> getAllUsers();
    public UsersDto getUserById(int id);
    public UsersDto updateUser(int id);
    public void deleteUser(int id);
}
