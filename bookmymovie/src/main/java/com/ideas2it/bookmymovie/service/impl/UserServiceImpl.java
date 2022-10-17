package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.UsersDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Users;
import com.ideas2it.bookmymovie.repository.UserRepository;
import com.ideas2it.bookmymovie.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapStructMapper mapper;
    private Users user;
    private UsersDto usersDto;

    public UserServiceImpl(UserRepository userRepository, MapStructMapper mapper, Users user, UsersDto usersDto) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.user = user;
        this.usersDto = usersDto;
    }

    /**
     * This method gets usersDto object as parameter to create user Details
     *
     * @param usersDto is passed as argument to add those value to the database.
     */
    @Override
    public UsersDto createUser(UsersDto usersDto) {
        usersDto.setCreationDate(LocalDate.now());
        return mapper.usersToUsersDto(userRepository.save(mapper.usersDtoToUsers(usersDto)));
    }
    /**
     * This method List all the User Details that are present in Database
     *
     * @return List<UsersDto> which will have all the Users Details which are present in
     * the database.
     */
    @Override
    public List<UsersDto> getAllUsers() throws NotFoundException {
        List<Users> users = userRepository.getAllUsersByStatus(false);
        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
        return users.stream()
                .map(mapper::usersToUsersDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getUserById(int id) throws NotFoundException {
        return userRepository.findById(id).map(mapper::usersToUsersDto)
                .orElseThrow(() ->new NotFoundException("No user found"));
    }

    @Override
    public UsersDto getUserByName(String name) throws NotFoundException {
        return userRepository.findByName(name).map(mapper::usersToUsersDto)
                .orElseThrow(() ->new NotFoundException("No user found"));
    }

    @Override
    public UsersDto updateUser(UsersDto usersDto){
        usersDto.setModifiedDate(LocalDate.now());
        return mapper.usersToUsersDto(userRepository.save(mapper.usersDtoToUsers(usersDto)));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
