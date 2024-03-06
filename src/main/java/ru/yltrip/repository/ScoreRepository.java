package ru.yltrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yltrip.model.Score;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Score} type and provide an open CRUD.
 */
@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {
}
