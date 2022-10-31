package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.dto.responseDto.UserSlimDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.User;
import com.ideas2it.bookmymovie.repository.UserRepository;
import com.ideas2it.bookmymovie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private MapStructMapper mapper;

    public UserServiceImpl(UserRepository userRepository, MapStructMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create customer detail
     * </p>
     *
     * @param userDto it contains user dto objects.
     * @return UserDto
     */
    @Override
    public UserSlimDto createUser(UserDto userDto) {
        return mapper.userToUserSlimDto(userRepository.save(mapper.userDtoToUser(userDto)));
    }

    /**
     * <p>
     * This method List all the User Details
     * </p>
     *
     * @return List<UserDto>
     */
    @Override
    public List<UserSlimDto> getAllUsers() {
        return userRepository.findAllByStatus(false).stream().
                map(mapper::userToUserSlimDto).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method get the User Details which matches the id
     * </p>
     *
     * @param id it contains user id
     * @return UserDto
     */
    @Override
    public UserDto getUserById(int id) {
        return userRepository.findById(id).map(mapper::userToUserDto)
                .orElseThrow(() ->new NotFoundException("No user found"));

    }

    /**
     * <p>
     * This method is to update the user details
     * </p>
     *
     * @param userDto it contains user dto objects.
     * @return ScreenDto
     */
    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findByUserId(userDto.getUserId());
        user.setStatus(userDto.isStatus());
        return mapper.userToUserDto(userRepository.save(user));
    }

    /**
     * <p>
     *  This method gets userDetails with userName.
     * </p>
     *
     * @param username it contains user name
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        System.out.print(userRepository.findByUserName(username).getUserName());
        //Role role = new Role();
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("The user name is not found for this id");
        } else {
            log.info("User found in the database: {}",username);
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleType()));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), grantedAuthorities);
    }
}

