package test.project.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import test.project.model.Role;
import test.project.model.User;
import test.project.repository.UserRepository;
import test.project.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public DataInitializer(RoleService roleService, UserRepository userRepository,
                           PasswordEncoder encoder) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @PostConstruct
    public void inject() {
        roleService.add(new Role(Role.RoleName.USER));
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        User user = new User();
        user.setUsername("admin");
        user.setPassword(encoder.encode("admin"));
        user.setRoles(Set.of(adminRole));
        userRepository.save(user);
    }
}
