package ru.yaltrip.repository;

import java.util.Optional;

public interface UserRepository<T> {
    /**
     * Find user by phone number
     *
     * @param phoneNumber phone number
     * @return {@link T} user
     */
    Optional<T> findByPhoneNumber(String phoneNumber);

    /**
     * Checks if there is a user with the same phone number
     *
     * @param phoneNumber phone number
     * @return true if phone number is occupied else false
     */
    boolean existsByPhoneNumber(String phoneNumber);
}
