package ru.yalrb.service;

import java.util.List;
import java.util.UUID;

/**
 * This interface provides a CRUD methods for manipulating {@link T} data.
 */
public interface CrudService<T> {
    T save(T entity);

    T getById(UUID id);

    List<T> getAll();

    T update(UUID id);

    void delete(UUID id);
}
