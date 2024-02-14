package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.AppealState;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link AppealState} type and provide an open CRUD.
 */
public interface AppealStateRepository extends JpaRepository<AppealState, UUID> {
}
