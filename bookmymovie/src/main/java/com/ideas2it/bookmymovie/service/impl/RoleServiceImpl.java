package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Role;
import com.ideas2it.bookmymovie.repository.RoleRepository;
import com.ideas2it.bookmymovie.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    private RoleDto roleDto;
    private Role role;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper mapper, RoleDto roleDto, Role role) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.roleDto = roleDto;
        this.role = role;
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        return mapper.map(roleRepository.save(mapper.map(roleDto, Role.class)),RoleDto.class);
    }

    @Override
    public List<RoleDto> getAllRoles() throws NotFoundException {
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            throw new NotFoundException("No roles found");
        }
        return roles.stream().map(role ->mapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    /*@Override
    public RoleDto getRoleById(int id) throws NotFoundException{
        role = roleRepository.findRoleById(id);
        if (null == role) {
            throw new NotFoundException("No role found");
        }
        return mapper.map(role , RoleDto.class);
    }*/

    @Override
    public RoleDto getRoleByName(String roleType) throws NotFoundException {
        role = roleRepository.findRoleByRoleType(roleType);
        if (null == role) {
            throw new NotFoundException("No role found");
        }
        return mapper.map(role, RoleDto.class);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }
}
