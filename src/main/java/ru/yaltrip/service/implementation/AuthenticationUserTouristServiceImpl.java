package ru.yaltrip.service.implementation;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.yaltrip.dto.JwtAuthenticationResponseDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.dto.SignUpRequestDTO;
import ru.yaltrip.mapper.AccountMapper;
import ru.yaltrip.model.Role;
import ru.yaltrip.model.UserTourist;
import ru.yaltrip.service.AuthenticationUserTouristService;
import ru.yaltrip.service.JwtService;
import ru.yaltrip.service.UserTouristService;

import java.util.Set;

/**
 * This class implements {@link AuthenticationUserTouristService} methods.
 * This service provides methods for registration and login in account into service YalTrip.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationUserTouristServiceImpl implements AuthenticationUserTouristService {
    private final UserTouristService userTouristService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * This method provides an opportunity to register an account in the YalTrip service.
     * @param request user data
     * @return JWT token
     */
    @Override
    public JwtAuthenticationResponseDTO signUp(SignUpRequestDTO request) {

        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

        UserTourist user = mapper.convertToEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(Role.ROLE_TOURIST));

        userTouristService.save(user);

        String jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponseDTO(jwt);
    }

    /**
     * This method provides an opportunity to login in account info in the YalTrip service.
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
