package ru.yalrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yalrb.model.Feedback;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Feedback} type and provide an open CRUD.
 */
public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
}
