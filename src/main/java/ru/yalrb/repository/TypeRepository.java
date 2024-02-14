package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Type;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Type} type and provide an open CRUD.
 */
public interface TypeRepository extends JpaRepository<Type, UUID> {
}
