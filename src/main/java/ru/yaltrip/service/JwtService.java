package ru.yaltrip.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * This interface provides a methods for working with Json Web Token (JWT).
 */
public interface JwtService {
    /**
     * Extract username from token.
     *
     * @param token token
     * @return username
     */
    String extractUserName(String token);

    /**
     * Generate token.
     *
     * @param userDetails user data
     * @return token
     */
    String generateToken(UserDetails userDetails);

    /**
     * Checking the validity of the token.
     *
     * @param token       token
     * @param userDetails user data
     * @return true, if token valid
     */
    boolean isTokenValid(String token, UserDetails userDetails);
}
