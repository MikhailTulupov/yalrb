package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Rate;

import java.util.UUID;

public interface RateRepository extends JpaRepository<Rate, UUID> {
}
