package ru.yltrip.service.implementation;

import org.springframework.stereotype.Service;
import ru.yltrip.model.Location;
import ru.yltrip.service.LocationService;

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
