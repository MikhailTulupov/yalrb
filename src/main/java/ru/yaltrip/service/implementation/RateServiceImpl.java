package ru.yaltrip.service.implementation;

import org.springframework.stereotype.Service;
import ru.yaltrip.model.Rate;
import ru.yaltrip.service.RateService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link RateService} interface methods.
 */
@Service
public class RateServiceImpl implements RateService {
    @Override
    public Rate save(Rate entity) {
        return null;
    }

    @Override
    public Rate getById(UUID id) {
        return null;
    }

    @Override
    public List<Rate> getAll() {
        return null;
    }

    @Override
    public Rate update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
