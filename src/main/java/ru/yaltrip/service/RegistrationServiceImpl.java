package ru.yaltrip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.yaltrip.model.AbstractUser;
import ru.yaltrip.model.Role;
import ru.yaltrip.model.UserEntrepreneur;
import ru.yaltrip.model.UserTourist;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserTouristService userTouristService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AbstractUser registration(AbstractUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user instanceof UserTourist) {
            user.setRoles(Set.of(Role.ROLE_TOURIST));
            return userTouristService.save((UserTourist) user);
        } else if (user instanceof UserEntrepreneur) {
            user.setRoles(Set.of(Role.ROLE_ENTREPRENEUR));
            return null;
        }

        return user;
    }
}
