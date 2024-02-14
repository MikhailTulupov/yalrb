package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Contact;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Contact} type and provide an open CRUD.
 */
public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
