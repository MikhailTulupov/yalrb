package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Contact;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
