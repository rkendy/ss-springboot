package br.uff.ihs.ss.service;

import java.util.List;

public interface CrudService<MODEL> {
    List<MODEL> findAll();

    MODEL findById(Long id);

    List<MODEL> findByFilter(MODEL filter);

    MODEL create(MODEL model);

    MODEL update(Long id, MODEL model);

    void delete(Long id);
}