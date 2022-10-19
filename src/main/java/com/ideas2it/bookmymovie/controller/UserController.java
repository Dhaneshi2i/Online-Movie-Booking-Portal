package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.RoleService;
import com.ideas2it.bookmymovie.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
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
    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() throws NotFoundException {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) throws NotFoundException {
        return userService.getUserById(id);
    }
    @PatchMapping("/{id}/{status}")
    public UserDto updateUser(@RequestBody UserDto userDto) throws NotFoundException {
        return userService.updateUser(userDto);
    }
    /*@DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }*/
}
