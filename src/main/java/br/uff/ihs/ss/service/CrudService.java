package br.uff.ihs.ss.service;

import java.util.List;

public interface CrudService<T> {
    List<T> findAll();

    T findById(Long id);

    List<T> findByFilter(T filter);

    T create(T T);

    T update(Long id, T bean);

    void delete(Long id);
}