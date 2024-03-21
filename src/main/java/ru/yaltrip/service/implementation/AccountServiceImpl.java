package ru.yaltrip.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.yaltrip.model.Level;
import ru.yaltrip.model.LevelType;
import ru.yaltrip.model.Role;
import ru.yaltrip.model.User;
import ru.yaltrip.repository.LevelTypeRepository;
import ru.yaltrip.repository.UserRepository;
import ru.yaltrip.service.AccountService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link AccountService} interface methods.
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;

    private final LevelTypeRepository levelTypeRepository;

    private final String STRANGER_LEVEL_TYPE = "Stranger";

    /**
     * User save in repository.
     * @param entity user
     * @return saved user
     */
    @Override
    public User save(User entity) {

        if (userRepository.existsByUsername(entity.getUsername())) {
            throw new RuntimeException("A user with that name already exists");
        }

        if (userRepository.existsByPhoneNumber(entity.getPhoneNumber())) {
            throw new RuntimeException("A user with that phone number already exists");
        }

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

        return userRepository.save(entity);
    }

    @Override
    public User getById(UUID id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User don't found"));
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByUserName;
    }

    @Override
    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUserName(username);
    }
}
