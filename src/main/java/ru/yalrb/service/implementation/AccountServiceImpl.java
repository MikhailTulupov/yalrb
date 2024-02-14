package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Account;
import ru.yalrb.service.AccountService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link AccountService} interface methods.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Account save(Account entity) {
        return null;
    }

    @Override
    public Account getById(UUID id) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Account update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
