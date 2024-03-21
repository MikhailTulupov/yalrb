package ru.yaltrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yaltrip.model.User;

import java.util.Optional;
import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link User} type and provide an open CRUD.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    /**
     * Find user by username
     *
     * @param username username
     * @return {@link User}
     */
    Optional<User> findByUsername(String username);

    /**
     * Checks if there is a user with the same username.
     *
     * @param username username
     * @return true if username is occupied else false.
     */
    boolean existsByUsername(String username);

    /**
     * Checks if there is a user with the same phone number
     *
     * @param phoneNumber phone number
     * @return true if phone number is occupied else false
     */
    boolean existsByPhoneNumber(String phoneNumber);
}
