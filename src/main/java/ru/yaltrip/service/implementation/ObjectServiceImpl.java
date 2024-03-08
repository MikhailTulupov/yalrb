package ru.yaltrip.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yaltrip.model.Account;
import ru.yaltrip.model.Object;
import ru.yaltrip.model.Photo;
import ru.yaltrip.model.Type;
import ru.yaltrip.repository.AccountRepository;
import ru.yaltrip.repository.ObjectRepository;
import ru.yaltrip.repository.TypeRepository;
import ru.yaltrip.service.ObjectService;

import java.util.List;
import java.util.UUID;

@Service
public class ObjectServiceImpl implements ObjectService {
    final ObjectRepository objectRepository;
    final TypeRepository typeRepository;
    final AccountRepository accountRepository;

    private final String TYPE_NAME = "Место исторического наследия";

    @Autowired
    public ObjectServiceImpl(ObjectRepository objectRepository,
                             TypeRepository typeRepository,
                             AccountRepository accountRepository) {
        this.objectRepository = objectRepository;
        this.typeRepository = typeRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Object save(Object entity) {
        Type type = typeRepository.findAll()
                .stream()
                .filter(t -> t.getName().equals(TYPE_NAME))
                .toList().getFirst();

        Account account = accountRepository.findById(entity.getAccount().getId())
                .orElseGet(Account::new);

        for(Photo photo: entity.getPhotos()) {
            photo.setObject(entity);
        }

        entity.setAccount(account);
        entity.setType(type);

        return objectRepository.save(entity);
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
