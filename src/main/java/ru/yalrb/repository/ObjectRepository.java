package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Object;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Object} type and provide an open CRUD.
 */
public interface ObjectRepository extends JpaRepository<Object, UUID> {
}
