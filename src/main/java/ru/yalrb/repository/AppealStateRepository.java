package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.AppealState;

import java.util.UUID;

public interface AppealStateRepository extends JpaRepository<AppealState, UUID> {
}
