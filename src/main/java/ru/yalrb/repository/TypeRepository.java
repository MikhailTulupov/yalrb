package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Type;

import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID> {
}
