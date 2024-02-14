package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Level;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Level} type and provide an open CRUD.
 */
public interface LevelRepository extends JpaRepository<Level, UUID> {
}
