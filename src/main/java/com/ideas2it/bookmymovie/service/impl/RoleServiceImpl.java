package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.repository.RoleRepository;
import com.ideas2it.bookmymovie.service.RoleService;
import com.ideas2it.bookmymovie.dto.responseDto.RoleSlimDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private MapStructMapper mapper;

    public RoleServiceImpl(RoleRepository roleRepository, MapStructMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }


    @Override
    public RoleDto createRole(RoleDto roleDto) {
        return mapper.roleToRoleDto(roleRepository.save(mapper.roleDtoToRole(roleDto)));
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream().map(role -> mapper.roleToRoleDto(role)).collect(Collectors.toList());
    }

    @Override
    public RoleSlimDto getRoleByRoleType(String roleType) throws NotFoundException {
        return roleRepository.findUserByRoleType(roleType).map(role ->mapper.roleToRoleSlimDto(role))
                .orElseThrow(() ->new NotFoundException("No role found"));
    }
}
