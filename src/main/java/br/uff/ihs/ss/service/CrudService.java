package br.uff.ihs.ss.service;

import java.util.List;

public interface CrudService<MODEL> {
    public List<MODEL> findAll();

    MODEL findById(Long id);

    MODEL create(MODEL model);

    MODEL update(Long id, MODEL model);

    void delete(Long id);
}