package ru.yaltrip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.yaltrip.model.Role;
import ru.yaltrip.model.UserEntrepreneur;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegistrationUserEntrepreneurServiceImpl implements RegistrationUserEntrepreneurService {
    private final UserTouristService userTouristService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserEntrepreneur registration(UserEntrepreneur user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.ROLE_ENTREPRENEUR));

        return user;
    }
}
