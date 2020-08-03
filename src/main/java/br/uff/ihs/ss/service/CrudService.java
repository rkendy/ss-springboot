package br.uff.ihs.ss.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.exception.NotFoundException;
import br.uff.ihs.ss.service.CrudService;

public abstract class CrudService<MODEL> {

    protected CrudRepository<MODEL, Long> repository;

    abstract protected Class<?> getModelClass();

    abstract protected void updateAttributes(MODEL toUpdate, MODEL updated);

    public MODEL create(MODEL model) {
        return repository.save(model);
    }

    public void delete(Long id) {
        MODEL toDelete = repository.findById(id).orElseThrow(() -> new NotFoundException(getModelClass(), id));
        repository.delete(toDelete);
    }

    public List<MODEL> findAll() {
        List<MODEL> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public List<MODEL> findByFilter(MODEL filter) {
        return null;
    }

    public MODEL findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(getModelClass(), id));
    }

    public MODEL update(Long id, MODEL model) {
        MODEL toUpdate = repository.findById(id).orElseThrow(() -> new NotFoundException(getModelClass(), id));
        updateAttributes(toUpdate, model);

        return repository.save(toUpdate);
    }

}