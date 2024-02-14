package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.State;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link State} type and provide an open CRUD.
 */
public interface StateRepository extends JpaRepository<State, UUID> {
}
