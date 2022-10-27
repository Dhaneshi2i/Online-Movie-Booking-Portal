package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.dto.responseDto.UserSlimDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserSlimDto createUser(UserDto userDto);
    List<UserSlimDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto updateUser(UserDto userDto);
}
