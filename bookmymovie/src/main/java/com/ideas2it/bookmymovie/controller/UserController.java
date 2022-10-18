package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.exception.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public UserController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostMapping("customer")
    public UsersDto createCustomer(@Valid @RequestBody UsersDto usersDto) throws NotFoundException {
        usersDto.setRole(roleService.getRoleByName("Customer"));
        return userService.createUser(usersDto);
    }

    @PostMapping("admin")
    public UsersDto createAdmin(@Valid @RequestBody UsersDto usersDto) throws NotFoundException {
        usersDto.setRole(roleService.getRoleByName("Admin"));
        return userService.createUser(usersDto);
    }
    @GetMapping("/getAllUsers")
    public List<UsersDto> getAllUsers() throws NotFoundException {
        return userService.getAllUsers();
    }
    @GetMapping("/viewUserById/{id}")
    public UsersDto getUserById(@PathVariable("id") int id) throws NotFoundException {
        return userService.getUserById(id);
    }
    @PatchMapping("updateUser/{id}/{status}")
    public UsersDto updateUser(@PathVariable("id") int id,@PathVariable boolean status) throws NotFoundException {
        UsersDto userDto = userService.getUserById(id);
        userDto.setStatus(status);
        return userService.updateUser(userDto);
    }
    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
