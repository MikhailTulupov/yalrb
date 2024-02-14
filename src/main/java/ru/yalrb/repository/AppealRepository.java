package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Appeal;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Appeal} type and provide an open CRUD.
 */
public interface AppealRepository extends JpaRepository<Appeal, UUID> {
}
