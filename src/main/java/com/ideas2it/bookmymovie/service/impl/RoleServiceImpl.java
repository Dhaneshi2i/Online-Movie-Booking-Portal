package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Role;
import com.ideas2it.bookmymovie.repository.RoleRepository;
import com.ideas2it.bookmymovie.service.RoleService;
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

    /**
     * <p>
     * This method is used to create Role Details
     * </p>
     *
     * @param roleDto it contains role dto objects
     * @return RoleDto
     */
    @Override
    public RoleDto createRole(RoleDto roleDto) {
        return mapper.roleToRoleDto(roleRepository.save(mapper.roleDtoToRole(roleDto)));
    }

    /**
     * <p>
     * This method List all the Role Details
     * </p>
     *
     * @return List<RoleDto>
     */
    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream().map(role -> mapper.roleToRoleDto(role)).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method gets Role Details which matches the role type
     * </p>
     *
     * @param roleType it contains role type
     * @return RoleSlimDto
     *
     */
    @Override
    public RoleDto getRoleByRoleType(String roleType) throws NotFoundException {
        return roleRepository.findUserByRoleType(roleType).map(role ->mapper.roleToRoleDto(role))
                .orElseThrow(() ->new NotFoundException("No role found"));
    }

    @Override
    public Role getRoleByRoleId(int roleId) {
        return roleRepository.findByRoleId(roleId);
    }
}
