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

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleDto createRoles( @Valid @RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }

    @GetMapping
    public List<RoleDto> getAllRoles() throws NotFoundException {
        return roleService.getAllRoles();
    }


    /*@DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
    }*/
}
