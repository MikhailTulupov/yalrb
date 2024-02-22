package ru.yalrb.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yalrb.model.State;
import ru.yalrb.repository.StateRepository;
import ru.yalrb.service.StateService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class implements {@link StateService} interface methods.
 */
@Service
public class StateServiceImpl implements StateService {

    @Autowired
    StateRepository stateRepository;

    @Override
    public State save(State entity) {
        return stateRepository.save(entity);
    }

    @Override
    public State update(UUID id) {
        return null;
    }

    @Override
    public State getById(UUID id) {
        Optional<State> state = stateRepository.findById(id);
        return state.orElseGet(State::new);
    }

    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        stateRepository.deleteById(id);
    }
}
