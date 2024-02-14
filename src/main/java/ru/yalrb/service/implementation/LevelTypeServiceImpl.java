package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.LevelType;
import ru.yalrb.service.LevelTypeService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link LevelTypeService} interface methods.
 */
@Service
public class LevelTypeServiceImpl implements LevelTypeService {
    @Override
    public LevelType save(LevelType entity) {
        return null;
    }

    @Override
    public LevelType getById(UUID id) {
        return null;
    }

    @Override
    public List<LevelType> getAll() {
        return null;
    }

    @Override
    public LevelType update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
