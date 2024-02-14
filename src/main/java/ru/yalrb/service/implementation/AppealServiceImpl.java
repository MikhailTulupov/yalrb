package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Appeal;
import ru.yalrb.service.AppealService;

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
