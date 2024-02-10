package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Score;

import java.util.UUID;

public interface ScoreRepository extends JpaRepository<Score, UUID> {
}
