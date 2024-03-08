package ru.yaltrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yaltrip.model.Contact;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Contact} type and provide an open CRUD.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
