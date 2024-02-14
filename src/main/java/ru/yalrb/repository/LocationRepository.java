package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Location;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Location} type and provide an open CRUD.
 */
public interface LocationRepository extends JpaRepository<Location, UUID> {
}
