package ru.yalrb.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yalrb.dto.ObjectDTO;
import ru.yalrb.mapper.ObjectMapper;
import ru.yalrb.model.Object;
import ru.yalrb.repository.ObjectRepository;
import ru.yalrb.service.ObjectService;

import java.util.List;
import java.util.UUID;

@Service
public class ObjectServiceImpl implements ObjectService {
    @Autowired
    ObjectRepository objectRepository;

    @Override
    public ObjectDTO save(ObjectDTO entity) {
        Object object = ObjectMapper.INSTANCE.convertToEntity(entity);

        return ObjectMapper.INSTANCE.convertToDTO(objectRepository.save(object));
    }

    @Override
    public ObjectDTO getById(UUID id) {
        return null;
    }

    @Override
    public List<ObjectDTO> getAll() {
        return null;
    }

    @Override
    public ObjectDTO update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
