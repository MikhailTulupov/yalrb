package ru.yltrip.service.implementation;

import org.springframework.stereotype.Service;
import ru.yltrip.model.Photo;
import ru.yltrip.service.PhotoService;

import java.util.List;
import java.util.UUID;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Override
    public Photo save(Photo entity) {
        return null;
    }

    @Override
    public Photo getById(UUID id) {
        return null;
    }

    @Override
    public List<Photo> getAll() {
        return null;
    }

    @Override
    public Photo update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
