package ru.yaltrip.service;

import ru.yaltrip.channel.model.JwtAuthenticationResponseDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.model.UserTourist;

/**
 * This interface provides a methods for registration and sign in {@link ru.yaltrip.model.UserTourist}.
 */
public interface RegistrationUserTouristService {
    /**
     * Registration user.
     *
     * @param user user data
     * @return token
     */
    UserTourist registration(UserTourist user);

    /**
     * User Authentication.
     *
     * @param request user data
     * @return token
     */
    JwtAuthenticationResponseDTO signIn(SignInRequestDTO request);
}
