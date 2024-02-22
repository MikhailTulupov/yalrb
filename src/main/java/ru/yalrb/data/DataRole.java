package ru.yalrb.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.yalrb.model.Role;
import ru.yalrb.service.RoleService;

@Component
public class DataRole implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    private Role user;
    private Role admin;

    @Override
    public void run(String... args) throws Exception {
        user = Role.builder()
                .name("User")
                .description("Common user")
                .build();

        admin = Role.builder()
                .name("Admin")
                .description("Admin privileges")
                .build();

        roleService.save(user);
        roleService.save(admin);
    }
}
