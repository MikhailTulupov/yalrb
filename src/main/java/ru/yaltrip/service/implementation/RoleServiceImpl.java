package ru.yaltrip.service.implementation;

import org.springframework.stereotype.Service;
import ru.yaltrip.model.Role;
import ru.yaltrip.repository.RoleRepository;
import ru.yaltrip.service.RoleService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class implements {@link RoleService} interface methods.
 */
@Service
public class RoleServiceImpl implements RoleService {

    final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role update(UUID id) {
        return null;
    }

    @Override
    public Role getById(UUID id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElseGet(Role::new);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        roleRepository.deleteById(id);
    }
}
