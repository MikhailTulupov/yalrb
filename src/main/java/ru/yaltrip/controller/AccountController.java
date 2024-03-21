package ru.yaltrip.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yaltrip.dto.JwtAuthenticationResponseDTO;
import ru.yaltrip.dto.SignInRequestDTO;
import ru.yaltrip.dto.SignUpRequestDTO;
import ru.yaltrip.mapper.AccountMapper;
import ru.yaltrip.model.User;
import ru.yaltrip.service.AccountService;
import ru.yaltrip.service.AuthenticationService;
import ru.yaltrip.service.LevelService;

/**
 * This class present's controller.
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    final AccountService accountService;
    final LevelService levelService;
    final AuthenticationService authenticationService;

    @Autowired
    public AccountController(AccountService accountService,
                             LevelService levelService,
                             AuthenticationService authenticationService) {
        this.accountService = accountService;
        this.levelService = levelService;
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "Register a new user")
    @PostMapping(value = "/registration",
            consumes = "application/json",
            produces = "application/json")
    public JwtAuthenticationResponseDTO addAccount(@RequestBody SignUpRequestDTO signUpRequestDTO) {

        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

        User user = mapper.convertToEntity(signUpRequestDTO);



//        user = accountService.save(user);

        return authenticationService.signUp(signUpRequestDTO);
    }
}