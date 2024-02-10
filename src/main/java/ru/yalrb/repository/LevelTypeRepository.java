package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.LevelType;

import java.util.UUID;

public interface LevelTypeRepository extends JpaRepository<LevelType, UUID> {
}
