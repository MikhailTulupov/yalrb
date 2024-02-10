package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
