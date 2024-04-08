package ru.yaltrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yaltrip.model.UserEntrepreneur;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link UserEntrepreneur} type and provide an open CRUD.
 */
@Repository
public interface UserEntrepreneurRepository extends JpaRepository<UserEntrepreneur, UUID> {
}
