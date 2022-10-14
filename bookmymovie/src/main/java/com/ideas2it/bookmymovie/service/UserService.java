package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.UsersDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface UserService {
    void createUser(UsersDto usersDto);
    public List<UsersDto> getAllUsers() throws NotFoundException;
    public UsersDto getUserById(int id) throws NotFoundException;
    public UsersDto updateUser(int id);
    public void deleteUser(int id);
}
