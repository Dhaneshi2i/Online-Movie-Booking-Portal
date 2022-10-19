package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.User;
import com.ideas2it.bookmymovie.repository.UserRepository;
import com.ideas2it.bookmymovie.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private MapStructMapper mapper;

    public UserServiceImpl(UserRepository userRepository, MapStructMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return mapper.userToUserDto(userRepository.save(mapper.userDtoToUser(userDto)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAllByStatus(false).stream().
                map(user ->mapper.userToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id) {
        return userRepository.findById(id).map(user -> mapper.userToUserDto(user))
                .orElseThrow(() ->new NotFoundException("No user found"));

    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).get();
        user.setStatus(userDto.isStatus());
        return mapper.userToUserDto(userRepository.save(user));
    }
}
