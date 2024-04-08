package ru.yaltrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yaltrip.model.UserTourist;

import java.util.Optional;
import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link UserTourist} type and provide an open CRUD.
 */
@Repository
public interface UserTouristRepository extends JpaRepository<UserTourist, UUID> {
    /**
     * Find user by phone number
     *
     * @param phoneNumber phone number
     * @return {@link UserTourist}
     */
    Optional<UserTourist> findByPhoneNumber(String phoneNumber);

    /**
     * Checks if there is a user with the same phone number
     *
     * @param phoneNumber phone number
     * @return true if phone number is occupied else false
     */
    boolean existsByPhoneNumber(String phoneNumber);
}
