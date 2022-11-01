package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.dto.responseDto.UserSlimDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.RoleService;
import com.ideas2it.bookmymovie.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * UserController will get the user detail to
 * Create users
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    /**
     * <p>
     * This method is used to create customer detail
     * </p>
     *
     * @param userDto it contains user dto objects.
     * @return UserDto
     */
    @PostMapping
    public UserSlimDto createCustomer(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }*/

    /**
     * <p>
     * This method List all the User Details
     * </p>
     *
     * @return List<UserDto>
     */
    @GetMapping
    public List<UserSlimDto> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * <p>
     * This method get the User Details which matches the id
     * </p>
     *
     * @param id it contains user id
     * @return UserDto
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    /**
     * <p>
     * This method is to update the user details
     * </p>
     *
     * @param userDto it contains user dto objects.
     * @return ScreenDto
     */
    @PatchMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

}