package ru.yaltrip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.yaltrip.channel.model.JwtAuthenticationResponseDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.model.Role;
import ru.yaltrip.model.UserTourist;

import java.util.Set;

/**
 * This class implements {@link RegistrationUserTouristService} methods.
 * This service provides methods for registration and login in account into service YalTrip.
 */
@Service
@RequiredArgsConstructor
public class RegistrationUserTouristServiceImpl implements RegistrationUserTouristService {
    private final UserTouristService userTouristService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * This method provides an opportunity to register an account in the YalTrip service.
     *
     * @param user user data
     * @return JWT token
     */
    @Override
    public UserTourist registration(UserTourist user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.ROLE_TOURIST));

        return userTouristService.save(user);
    }

    /**
     * This method provides an opportunity to login in account info in the YalTrip service.
     *
     * @param request user data
     * @return JWT token
     */
    @Override
    public JwtAuthenticationResponseDTO signIn(SignInRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getPhoneNumber(),
                request.getPassword()
        ));

        var user = userTouristService.userDetailsService().loadUserByUsername(request.getPhoneNumber());

        var jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponseDTO(jwt);
    }
}
