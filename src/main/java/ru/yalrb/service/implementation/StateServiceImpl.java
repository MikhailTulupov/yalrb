package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.State;
import ru.yalrb.service.StateService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link StateService} interface methods.
 */
@Service
public class StateServiceImpl implements StateService {
    @Override
    public State save(State entity) {
        return null;
    }

    @Override
    public State getById(UUID id) {
        return null;
    }

    @Override
    public List<State> getAll() {
        return null;
    }

    @Override
    public State update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
