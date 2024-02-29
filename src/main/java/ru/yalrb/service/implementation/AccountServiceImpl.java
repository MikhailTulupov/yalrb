package ru.yalrb.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yalrb.dto.AccountDTO;
import ru.yalrb.mapper.AccountMapper;
import ru.yalrb.model.Account;
import ru.yalrb.model.Level;
import ru.yalrb.model.LevelType;
import ru.yalrb.model.Role;
import ru.yalrb.repository.AccountRepository;
import ru.yalrb.service.AccountService;
import ru.yalrb.service.LevelTypeService;
import ru.yalrb.service.RoleService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link AccountService} interface methods.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    LevelTypeService levelTypeService;

    @Override
    public AccountDTO save(AccountDTO entity) {
        List<Role> roles = roleService.getAll();
        Role role = roles.stream().filter(element -> element.getName().equals("User")).toList().getFirst();
        List<LevelType> levelTypes = levelTypeService.getAll();
        LevelType levelType = levelTypes.stream().filter(type -> type.getName().equals("Stranger")).toList().getFirst();
        Level level = Level.builder()
                .score(0)
                .levelType(levelType)
                .build();

        Account account = AccountMapper.INSTANCE.convertToEntity(entity);

        account.setLevel(level);
        account.setCreatedDateTime(new Date());
        account.setRole(role);

        return AccountMapper.INSTANCE.convertToDTO(accountRepository.save(account));
    }

    @Override
    public AccountDTO getById(UUID id) {
        return null;
    }

    @Override
    public List<AccountDTO> getAll() {
        return null;
    }

    @Override
    public AccountDTO update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
