package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Score;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Score} type and provide an open CRUD.
 */
public interface ScoreRepository extends JpaRepository<Score, UUID> {
}
