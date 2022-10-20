package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Role;
import com.ideas2it.bookmymovie.model.User;
import com.ideas2it.bookmymovie.repository.UserRepository;
import com.ideas2it.bookmymovie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final MapStructMapper mapper;

    public UserServiceImpl(UserRepository userRepository, MapStructMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return mapper.userToUserDto(userRepository.save(mapper.userDtoToUser(userDto)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAllByStatus(false).stream().
                map(mapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id) {
        return userRepository.findById(id).map(mapper::userToUserDto)
                .orElseThrow(() ->new NotFoundException("No user found"));

    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).get();
        user.setStatus(userDto.isStatus());
        return mapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        Role role = new Role();
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("The user name is not found for this id");
        } else {
            log.info("User found in the database: {}",username);
        }
        SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(role.getRoleType());
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), Collections.singleton(authorities));
    }
}
