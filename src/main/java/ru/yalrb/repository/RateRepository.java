package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Rate;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Rate} type and provide an open CRUD.
 */
public interface RateRepository extends JpaRepository<Rate, UUID> {
}
