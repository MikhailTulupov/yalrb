package ru.yltrip.service.implementation;

import org.springframework.stereotype.Service;
import ru.yltrip.model.Appeal;
import ru.yltrip.service.AppealService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link AppealService} interface methods.
 */
@Service
public class AppealServiceImpl implements AppealService {
    @Override
    public Appeal save(Appeal entity) {
        return null;
    }

    @Override
    public Appeal getById(UUID id) {
        return null;
    }

    @Override
    public List<Appeal> getAll() {
        return null;
    }

    @Override
    public Appeal update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
