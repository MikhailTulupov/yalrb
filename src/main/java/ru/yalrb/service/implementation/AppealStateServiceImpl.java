package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.AppealState;
import ru.yalrb.service.AppealStateService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link AppealStateService} interface methods.
 */
@Service
public class AppealStateServiceImpl implements AppealStateService {
    @Override
    public AppealState save(AppealState entity) {
        return null;
    }

    @Override
    public AppealState getById(UUID id) {
        return null;
    }

    @Override
    public List<AppealState> getAll() {
        return null;
    }

    @Override
    public AppealState update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
