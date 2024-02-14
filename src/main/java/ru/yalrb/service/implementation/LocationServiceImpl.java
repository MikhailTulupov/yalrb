package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Location;
import ru.yalrb.service.LocationService;

import java.util.List;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {
    @Override
    public Location save(Location entity) {
        return null;
    }

    @Override
    public Location getById(UUID id) {
        return null;
    }

    @Override
    public List<Location> getAll() {
        return null;
    }

    @Override
    public Location update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
