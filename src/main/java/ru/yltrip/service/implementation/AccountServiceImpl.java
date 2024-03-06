package ru.yltrip.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yltrip.model.Account;
import ru.yltrip.model.Level;
import ru.yltrip.model.LevelType;
import ru.yltrip.model.Role;
import ru.yltrip.repository.AccountRepository;
import ru.yltrip.repository.LevelTypeRepository;
import ru.yltrip.repository.RoleRepository;
import ru.yltrip.service.AccountService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link AccountService} interface methods.
 */
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final LevelTypeRepository levelTypeRepository;

    private final String USER_ROLE = "User";
    private final String STRANGER_LEVEL_TYPE = "Stranger";

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              RoleRepository roleRepository,
                              LevelTypeRepository LevelTypeRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.levelTypeRepository = LevelTypeRepository;
    }

    @Override
    public Account save(Account entity) {
        List<Role> roles = roleRepository.findAll();
        Role role = roles.stream()
                .filter(element -> element
                        .getName()
                        .equals(USER_ROLE))
                .toList()
                .getFirst();

        List<LevelType> levelTypes = levelTypeRepository.findAll();
        LevelType levelType = levelTypes.stream()
                .filter(type -> type
                        .getName()
                        .equals(STRANGER_LEVEL_TYPE))
                .toList()
                .getFirst();

        Level level = Level.builder()
                .score(0)
                .levelType(levelType)
                .build();

        entity.setLevel(level);
        entity.setCreatedDateTime(new Date());
        entity.setRole(role);

        return accountRepository.save(entity);
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
