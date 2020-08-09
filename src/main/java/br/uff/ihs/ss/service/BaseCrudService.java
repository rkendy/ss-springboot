package br.uff.ihs.ss.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.exception.ConflictException;
import br.uff.ihs.ss.exception.NotFoundException;

public abstract class BaseCrudService<MODEL> {

    private CrudRepository<MODEL, Long> repository;
    private Class<?> modelClass;

    protected abstract void updateCrudAttributes(MODEL to, MODEL from);

    public void setRepository(CrudRepository<MODEL, Long> repository) {
        this.repository = repository;
    }

    public void setModelClass(Class<?> modelClass) {
        this.modelClass = modelClass;
    }

    public MODEL create(MODEL model) {
        MODEL newModel;
        try {
            newModel = repository.save(model);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException(modelClass, e.getMessage());
        }
        return newModel;
    }

    public void delete(Long id) {
        MODEL toDelete = repository.findById(id).orElseThrow(() -> new NotFoundException(modelClass, id));
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
        return repository.findById(id).orElseThrow(() -> new NotFoundException(modelClass, id));
    }

    public MODEL update(Long id, MODEL model) {
        MODEL toUpdate = repository.findById(id).orElseThrow(() -> new NotFoundException(modelClass, id));
        updateCrudAttributes(toUpdate, model);
        MODEL updated;
        try {
            updated = repository.save(toUpdate);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException(modelClass, e.getMessage());
        }
        return updated;
    }

}