package cinema.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import cinema.model.Role;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.model.User;
import cinema.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public DataInitializer(RoleService roleService,
                           UserService userService,
                           AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
        User userOne = new User();
        userOne.setEmail("admin@mail.ua");
        userOne.setPassword("admin123");
        userOne.setRoles(Set.of(adminRole));
        userService.add(userOne);
        authenticationService.register("user@mail.ua", "user123");
    }
}
