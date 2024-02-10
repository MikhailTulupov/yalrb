package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Level;

import java.util.UUID;

public interface LevelRepository extends JpaRepository<Level, UUID> {
}
