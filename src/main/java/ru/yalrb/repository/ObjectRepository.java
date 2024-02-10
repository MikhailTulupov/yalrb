package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Object;

import java.util.UUID;

public interface ObjectRepository extends JpaRepository<Object, UUID> {
}
