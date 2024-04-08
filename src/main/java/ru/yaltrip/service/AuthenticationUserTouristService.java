package ru.yaltrip.service;

import ru.yaltrip.dto.JwtAuthenticationResponseDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.dto.SignUpRequestDTO;

/**
 * This interface provides a methods for registration and sign in {@link ru.yaltrip.model.UserTourist}.
 */
public interface AuthenticationUserTouristService {
    /**
     * Registration user.
     *
     * @param request user data
     * @return token
     */
    JwtAuthenticationResponseDTO signUp(SignUpRequestDTO request);

    /**
     * User Authentication.
     *
     * @param request user data
     * @return token
     */
    JwtAuthenticationResponseDTO signIn(SignInRequestDTO request);
}
