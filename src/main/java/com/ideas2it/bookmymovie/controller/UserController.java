package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.UserDto;
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

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/customer")
    public UserDto createCustomer(@Valid @RequestBody UserDto userDto) throws NotFoundException {
        userDto.setRole(roleService.getRoleByRoleType("Customer"));
        return userService.createUser(userDto);
    }

    @PostMapping("/admin")
    public UserDto createAdmin(@Valid @RequestBody UserDto userDto) throws NotFoundException {
        userDto.setRole(roleService.getRoleByRoleType("Admin"));
        return userService.createUser(userDto);
    }

    @GetMapping
    public List<UserDto> getAllUsers() throws NotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) throws NotFoundException {
        return userService.getUserById(id);
    }

    @PatchMapping
    public UserDto updateUser(@RequestBody UserDto userDto)
            throws NotFoundException {
        return userService.updateUser(userDto);
    }

}
