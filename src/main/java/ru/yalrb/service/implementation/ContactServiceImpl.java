package ru.yalrb.service.implementation;

import org.springframework.stereotype.Service;
import ru.yalrb.model.Contact;
import ru.yalrb.service.ContactService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements {@link ContactService} interface methods.
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Override
    public Contact save(Contact entity) {
        return null;
    }

    @Override
    public Contact getById(UUID id) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }

    @Override
    public Contact update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
