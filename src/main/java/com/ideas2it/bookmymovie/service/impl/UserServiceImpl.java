package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.dto.responseDto.UserResponseDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.exception.AlreadyExistException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.User;
import com.ideas2it.bookmymovie.repository.UserRepository;
import com.ideas2it.bookmymovie.service.RoleService;
import com.ideas2it.bookmymovie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MapStructMapper mapper;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder, MapStructMapper mapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
    public UserResponseDto createUser(UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        if(userRepository.existsByContactNumber(user.getContactNumber())) {
            throw new AlreadyExistException("User mobile number already exist ");
        } else if (userRepository.existsByUserName(user.getUserName())) {
            throw new AlreadyExistException("UserName already exist, please provide different userName");
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            user.setRole(roleService.getRoleByRoleId(userDto.getRole().getId()));
            return mapper.userToUserResponseDto(userRepository.save(user));
        }
    }

    /**
     * <p>
     * This method List all the User Details
     * </p>
     *
     * @return List<UserDto>
     */
    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAllByStatus(false).stream().
                map(mapper::userToUserResponseDto).collect(Collectors.toList());
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
    @Cacheable(value = "user")
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
    @CachePut(value = "user",key = "#userDto.getUserId()")
    public UserDto updateUser(UserDto userDto) {
        return mapper.userToUserDto(userRepository.save(mapper.userDtoToUser(userDto)));
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

