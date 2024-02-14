package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Photo;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Photo} type and provide an open CRUD.
 */
public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}
