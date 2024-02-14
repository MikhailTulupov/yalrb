package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Type;
import ru.yalrb.service.TypeService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link TypeService} interface methods.
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Override
    public Type save(Type entity) {
        return null;
    }

    @Override
    public Type getById(UUID id) {
        return null;
    }

    @Override
    public List<Type> getAll() {
        return null;
    }

    @Override
    public Type update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
