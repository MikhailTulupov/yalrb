package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Location;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
