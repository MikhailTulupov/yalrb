package ru.yltrip.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.yltrip.model.Role;
import ru.yltrip.service.RoleService;

@Component
public class RoleData implements CommandLineRunner {
    private final RoleService roleService;

    final String ROLE_USER = "User";
    final String ROLE_ADMIN = "Admin";
    final String ROLE_USER_DESCRIPTION = "Common user";
    final String ROLE_ADMIN_DESCRIPTION = "Admin privileges";

    @Autowired
    public RoleData(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) {
        Role user = Role.builder()
                .name(ROLE_USER)
                .description(ROLE_USER_DESCRIPTION)
                .build();

        Role admin = Role.builder()
                .name(ROLE_ADMIN)
                .description(ROLE_ADMIN_DESCRIPTION)
                .build();

        roleService.save(user);
        roleService.save(admin);
    }
}
