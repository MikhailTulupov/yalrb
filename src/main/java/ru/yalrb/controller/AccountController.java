package ru.yalrb.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yalrb.dto.AccountDTO;
import ru.yalrb.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Operation(summary = "Register a new user")
    @PostMapping(value = "/registration",
            consumes = "application/json",
            produces = "application/json")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.save(accountDTO);
    }
}