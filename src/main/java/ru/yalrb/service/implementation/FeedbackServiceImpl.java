package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Feedback;
import ru.yalrb.service.FeedbackService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link FeedbackService} interface methods.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public Feedback save(Feedback entity) {
        return null;
    }

    @Override
    public Feedback getById(UUID id) {
        return null;
    }

    @Override
    public List<Feedback> getAll() {
        return null;
    }

    @Override
    public Feedback update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
