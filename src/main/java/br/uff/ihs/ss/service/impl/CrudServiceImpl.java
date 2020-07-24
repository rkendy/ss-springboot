package br.uff.ihs.ss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.exception.NotFoundException;
import br.uff.ihs.ss.service.CrudService;

public abstract class CrudServiceImpl<MODEL> implements CrudService<MODEL> {

    @Autowired
    protected CrudRepository<MODEL, Long> repository;

    abstract protected Class<?> getModelClass();

    abstract protected void updateAttributes(MODEL toUpdate, MODEL updated);

    @Override
    public MODEL create(MODEL model) {
        return repository.save(model);
    }

    @Override
    public void delete(Long id) {
        MODEL toDelete = repository.findById(id).orElseThrow(() -> new NotFoundException(getModelClass(), id));
        repository.delete(toDelete);
    }

    @Override
    public List<MODEL> findAll() {
        List<MODEL> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List findByFilter(MODEL filter) {
        return null;
    }

    @Override
    public MODEL findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(getModelClass(), id));
    }

    @Override
    public MODEL update(Long id, MODEL model) {
        MODEL toUpdate = repository.findById(id).orElseThrow(() -> new NotFoundException(getModelClass(), id));
        updateAttributes(toUpdate, model);

        return repository.save(toUpdate);
    }

}