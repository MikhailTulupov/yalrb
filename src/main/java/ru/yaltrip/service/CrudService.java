package ru.yaltrip.service;

import java.util.List;
import java.util.UUID;

/**
 * This interface provides a CRUD methods for manipulating {@link T} data from {@link T} repository annotated with
 * {@link org.springframework.stereotype.Repository}.
 */
public interface CrudService<T> {
    /**
     * Save entity to database.
     *
     * @param entity entity
     * @return entity
     */
    default T save(T entity) {
        return null;
    }

    /**
     * Find entity by id and return this entity.
     *
     * @param id identifier
     * @return entity
     */
    default T getById(UUID id) {
        return null;
    }

    /**
     * Return list of {@link T} entity's.
     *
     * @return list of entity's.
     */
    default List<T> getAll() {
        return null;
    }

    /**
     * Update entity in database.
     *
     * @param id identifier
     * @return updated entity.
     */
    default T update(UUID id) {
        return null;
    }

    /**
     * Delete entity by id from database.
     *
     * @param id identifier.
     */
    default void delete(UUID id) {
        return;
    }
}
