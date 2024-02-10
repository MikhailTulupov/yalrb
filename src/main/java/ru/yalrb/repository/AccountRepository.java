package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
