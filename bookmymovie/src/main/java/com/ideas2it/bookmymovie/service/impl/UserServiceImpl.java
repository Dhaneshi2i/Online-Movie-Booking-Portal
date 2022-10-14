package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.UsersDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Users;
import com.ideas2it.bookmymovie.repository.UserRepository;
import com.ideas2it.bookmymovie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private Users user;
    private UsersDto usersDto;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, Users user, UsersDto usersDto) {
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
        return mapper.map(userRepository.save(mapper.map(usersDto,Users.class)), UsersDto.class);
    }
    /**
     * This method List all the User Details that are present in Database
     *
     * @return List<UsersDto> which will have all the Users Details which are present in
     * the database.
     */
    @Override
    public List<UsersDto> getAllUsers() throws NotFoundException {
        List<Users> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("No user found");
        }
        return users.stream()
                .map(user -> mapper.map(user, UsersDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public UsersDto getUserById(int id) throws NotFoundException {
        user = userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException("No user found");
        }
        return mapper.map(user , UsersDto.class);
    }

    @Override
    public UsersDto updateUser(UsersDto usersDto){
        usersDto.setModifiedDate(LocalDate.now());
        return mapper.map(userRepository.save(mapper.map(usersDto, Users.class)), UsersDto.class);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
