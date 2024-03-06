package ru.yltrip.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yltrip.model.Account;
import ru.yltrip.model.Object;
import ru.yltrip.model.Photo;
import ru.yltrip.model.Type;
import ru.yltrip.repository.AccountRepository;
import ru.yltrip.repository.ObjectRepository;
import ru.yltrip.repository.TypeRepository;
import ru.yltrip.service.ObjectService;

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
