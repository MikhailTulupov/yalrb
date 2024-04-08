package ru.yaltrip.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * This interface provides a methods for working with Json Web Token (JWT).
 */
public interface JwtService {
    /**
     * Extract phone number from token.
     *
     * @param token token
     * @return phone number
     */
    String extractPhoneNumber(String token);

    /**
     * Extract email from token.
     *
     * @param token token
     * @return email
     */
    String extractEmail(String token);

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
