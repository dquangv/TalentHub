package org.example.backend.service;

import java.util.List;

public interface BaseService<T> {
    T create(T t);
    T delete(T t);
    T get(T t);
    List<T> getAll();

}
