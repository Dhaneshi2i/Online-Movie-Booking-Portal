package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.UsersDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface UserService {
    /**
     * This method gets usersDto object as parameter to create user Details
     *
     * @param usersDto is passed as argument to add those value to the database.
     */
    UsersDto createUser(UsersDto usersDto);
    /**
     * This method List all the User Details that are present in Database
     *
     * @return List<UsersDto> which will have all the Users Details which are present in
     * the database.
     */
    public List<UsersDto> getAllUsers() throws NotFoundException;
    public UsersDto getUserById(int id) throws NotFoundException;
    UsersDto getUserByName(String name) throws NotFoundException;

    UsersDto updateUser(UsersDto usersDto);

    public void deleteUser(int id);
}
