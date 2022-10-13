package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.UsersDto;
import com.ideas2it.bookmymovie.model.Users;
import com.ideas2it.bookmymovie.repository.UserRepository;
import com.ideas2it.bookmymovie.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final Users user;
    private UsersDto usersDto;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, Users user, UsersDto usersDto) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.user = user;
        this.usersDto = usersDto;
    }

    @Override
    public void createUser(UsersDto usersDto) {
        Users user = mapper.map(usersDto, Users.class);
        userRepository.save(user);
    }

    @Override
    public List<UsersDto> getAllUsers() throws NotFoundException{
        List<Users> user = userRepository.findAll();
        if (user.isEmpty()) {
            usersDto = mapper.map(user, UsersDto.class);
            return (List<UsersDto>)usersDto;
        } else {
            throw new NotFoundException("No user found");
        }
//        usersDto = mapper.map(user, UsersDto.class);
//        return (List<UsersDto>)usersDto;
    }

    @Override
    public UsersDto getUserById(int id) throws NotFoundException{
        //return mapper.map(userRepository.findById(id), UsersDto.class);
        usersDto = mapper.map(userRepository.findById(id), UsersDto.class);
        if (usersDto != null) {
            return usersDto;
        } else {
            throw new NotFoundException("No user found");
        }
    }

    @Override
    public UsersDto updateUser(int id){
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
