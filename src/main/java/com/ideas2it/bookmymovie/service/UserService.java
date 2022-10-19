package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto updateUser(UserDto userDto);
}
