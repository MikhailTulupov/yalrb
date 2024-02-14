package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Role;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Role} type and provide an open CRUD.
 */
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
