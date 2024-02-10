package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.State;

import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {
}
