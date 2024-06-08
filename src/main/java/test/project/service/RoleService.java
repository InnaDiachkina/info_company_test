package test.project.service;

import test.project.model.Role;

public interface RoleService {
    Role findByRoleName(String roleName);

    void add(Role role);
}
