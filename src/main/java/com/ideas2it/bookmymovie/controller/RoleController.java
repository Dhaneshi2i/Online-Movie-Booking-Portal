package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * RoleController will get the detail from admin to
 * Create roles for the user.
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * <p>
     * This method is used to create Role Details
     * </p>
     *
     * @param roleDto it contains role dto objects
     * @return RoleDto
     */
    @PostMapping
    public RoleDto createRoles( @Valid @RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }

    /**
     * <p>
     * This method List all the Role Details
     * </p>
     *
     * @return List<RoleDto>
     */
    @GetMapping
    public List<RoleDto> getAllRoles() throws NotFoundException {
        return roleService.getAllRoles();
    }

}
