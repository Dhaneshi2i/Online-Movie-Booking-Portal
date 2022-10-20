package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleDto createRoles(@RequestBody RoleDto roleDto) {
        return roleService.saveRole(roleDto);
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
