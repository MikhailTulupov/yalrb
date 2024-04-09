package ru.yaltrip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yaltrip.model.Object;
import ru.yaltrip.model.Photo;
import ru.yaltrip.model.Type;
import ru.yaltrip.model.UserEntrepreneur;
import ru.yaltrip.repository.ObjectRepository;
import ru.yaltrip.repository.TypeRepository;
import ru.yaltrip.repository.UserEntrepreneurRepository;

/**
 * This class implements {@link ObjectService} methods for manipulating object model.
 */
@RequiredArgsConstructor
@Service
public class ObjectServiceImpl implements ObjectService {
    final ObjectRepository objectRepository;
    final TypeRepository typeRepository;
    final UserEntrepreneurRepository userEntrepreneurRepository;

    private final String TYPE_NAME = "Место исторического наследия";

    @Override
    public Object save(Object entity) {
        Type type = typeRepository.findAll()
                .stream()
                .filter(t -> t.getName().equals(TYPE_NAME))
                .toList().getFirst();

        UserEntrepreneur user = userEntrepreneurRepository.findById(entity.getUser().getId())
                .orElseGet(UserEntrepreneur::new);

        for (Photo photo : entity.getPhotos()) {
            photo.setObject(entity);
        }

        entity.setUser(user);
        entity.setType(type);

        return objectRepository.save(entity);
    }
}
