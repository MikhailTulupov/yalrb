package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Role;
import ru.yalrb.service.RoleService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link RoleService} interface methods.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Role save(Role entity) {
        return null;
    }

    @Override
    public Role getById(UUID id) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
