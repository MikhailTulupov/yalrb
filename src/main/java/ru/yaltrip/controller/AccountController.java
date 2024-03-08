package ru.yaltrip.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yaltrip.dto.AccountDTO;
import ru.yaltrip.dto.AddAccountDTO;
import ru.yaltrip.mapper.AccountMapper;
import ru.yaltrip.model.Account;
import ru.yaltrip.service.AccountService;
import ru.yaltrip.service.LevelService;

/**
 * This class present's controller.
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    final AccountService accountService;
    final LevelService levelService;

    @Autowired
    public AccountController(AccountService accountService, LevelService levelService) {
        this.accountService = accountService;
        this.levelService = levelService;
    }

    @Operation(summary = "Register a new user")
    @PostMapping(value = "/registration",
            consumes = "application/json",
            produces = "application/json")
    public AccountDTO addAccount(@RequestBody AddAccountDTO addAccountDTO) {

        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

        Account account = mapper.convertToEntity(addAccountDTO);

        account = accountService.save(account);

        return mapper.convertToDTO(account);
    }
}