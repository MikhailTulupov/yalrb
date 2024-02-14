package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Account;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Account} type and provide an open CRUD.
 */
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
