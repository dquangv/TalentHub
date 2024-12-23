package org.example.backend.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T create(T t);
    Optional<T> getById(ID id);
    List<T> getAll();
    Boolean deleteById(ID id);
}
