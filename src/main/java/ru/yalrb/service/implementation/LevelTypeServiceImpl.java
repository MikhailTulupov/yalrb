package ru.yalrb.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yalrb.model.LevelType;
import ru.yalrb.repository.LevelTypeRepository;
import ru.yalrb.service.LevelTypeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class implements {@link LevelTypeService} interface methods.
 */
@Service
public class LevelTypeServiceImpl implements LevelTypeService {

    @Autowired
    LevelTypeRepository levelTypeRepository;

    @Override
    public LevelType update(UUID id) {
        return null;
    }

    @Override
    public LevelType save(LevelType entity) {
        return levelTypeRepository.save(entity);
    }

    @Override
    public LevelType getById(UUID id) {
        Optional<LevelType> levelType = levelTypeRepository.findById(id);
        return levelType.orElseGet(LevelType::new);
    }

    @Override
    public List<LevelType> getAll() {
        return levelTypeRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        levelTypeRepository.deleteById(id);
    }
}
