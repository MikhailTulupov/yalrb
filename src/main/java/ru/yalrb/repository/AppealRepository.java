package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Appeal;

import java.util.UUID;

public interface AppealRepository extends JpaRepository<Appeal, UUID> {
}
