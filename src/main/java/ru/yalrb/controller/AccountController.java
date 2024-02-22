package ru.yalrb.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yalrb.model.Account;
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
    public Account addAccount(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "register a new user",
            required = true,
            content = @Content(
                    schema = @Schema(
                            example =
                                    """
                                            {
                                                "id": null,
                                                "role": null,
                                                "level": null,
                                                "login": "user123",
                                                "password": "qwerty",
                                                "phoneNumber": "+79999999999",
                                                "createdDateTime": null
                                            }
                                            """)
            )
    )
                              @JsonInclude(JsonInclude.Include.NON_NULL)
                              @RequestBody Account account) {
        return accountService.save(account);
    }
}
