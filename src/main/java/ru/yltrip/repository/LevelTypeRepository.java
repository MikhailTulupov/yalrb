package ru.yltrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yltrip.model.LevelType;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link LevelType} type and provide an open CRUD.
 */
@Repository
public interface LevelTypeRepository extends JpaRepository<LevelType, UUID> {
}
