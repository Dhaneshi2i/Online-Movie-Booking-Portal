package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Role;
import com.ideas2it.bookmymovie.repository.RoleRepository;
import com.ideas2it.bookmymovie.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * This {@Code RoleService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final MapStructMapper mapper;

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
        return roleRepository.findAll().stream().map(mapper::roleToRoleDto).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method gets Role Details which matches the role type
     * </p>
     *
     * @param roleId it contains role type
     * @return Role
     *
     */
    @Override
    public Role getRoleByRoleId(int roleId) {
        return roleRepository.findByRoleId(roleId);
    }
}
