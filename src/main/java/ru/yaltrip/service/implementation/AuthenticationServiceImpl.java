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
import ru.yaltrip.model.User;
import ru.yaltrip.service.AccountService;
import ru.yaltrip.service.AuthenticationService;
import ru.yaltrip.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountService accountService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponseDTO signUp(SignUpRequestDTO request) {

        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

        User user = mapper.convertToEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        accountService.save(user);

        var jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponseDTO(jwt);
    }

    @Override
    public JwtAuthenticationResponseDTO signIn(SignInRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getLogin(),
                request.getPassword()
        ));

        var user = accountService.userDetailsService().loadUserByUsername(request.getLogin());

        var jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponseDTO(jwt);
    }
}
