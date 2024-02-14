package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Level;
import ru.yalrb.service.LevelService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link LevelService} interface methods.
 */
@Service
public class LevelServiceImpl implements LevelService {
    @Override
    public Level save(Level entity) {
        return null;
    }

    @Override
    public Level getById(UUID id) {
        return null;
    }

    @Override
    public List<Level> getAll() {
        return null;
    }

    @Override
    public Level update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
