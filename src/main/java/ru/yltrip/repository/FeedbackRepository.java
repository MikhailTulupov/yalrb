package ru.yltrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yltrip.model.Feedback;

import java.util.UUID;

/**
 * The general purpose of this interface is to store information
 * about the {@link Feedback} type and provide an open CRUD.
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
}
