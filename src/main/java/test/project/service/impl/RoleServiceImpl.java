package test.project.service.impl;

import org.springframework.stereotype.Service;
import test.project.model.Role;
import test.project.repository.RoleRepository;
import test.project.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(Role.RoleName.valueOf(roleName))
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }
}
