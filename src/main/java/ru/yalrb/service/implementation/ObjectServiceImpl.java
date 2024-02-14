package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Object;
import ru.yalrb.service.ObjectService;

import java.util.List;
import java.util.UUID;

@Service
public class ObjectServiceImpl implements ObjectService {
    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Object getById(UUID id) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public Object update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
