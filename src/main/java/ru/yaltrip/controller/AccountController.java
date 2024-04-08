package ru.yaltrip.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yaltrip.dto.JwtAuthenticationResponseDTO;
import ru.yaltrip.dto.SignUpRequestDTO;
import ru.yaltrip.service.AuthenticationUserTouristService;
import ru.yaltrip.service.UserTouristService;

/**
 * This class present's controller.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    final UserTouristService userTouristService;
    final AuthenticationUserTouristService authenticationUserTouristService;

    @Operation(summary = "Register a new user")
    @PostMapping(value = "/registration",
            consumes = "application/json",
            produces = "application/json")
    public JwtAuthenticationResponseDTO addAccount(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        return authenticationUserTouristService.signUp(signUpRequestDTO);
    }
}
