package test.project.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import test.project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(Role.RoleName roleName);
    boolean existsByRoleName(Role.RoleName roleName);
}
