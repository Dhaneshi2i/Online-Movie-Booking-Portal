package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto updateUser(UserDto userDto);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
