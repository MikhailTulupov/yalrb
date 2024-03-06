package ru.yltrip.service.implementation;

import org.springframework.stereotype.Service;
import ru.yltrip.model.Score;
import ru.yltrip.service.ScoreService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link ScoreService} interface methods.
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Override
    public Score save(Score entity) {
        return null;
    }

    @Override
    public Score getById(UUID id) {
        return null;
    }

    @Override
    public List<Score> getAll() {
        return null;
    }

    @Override
    public Score update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
