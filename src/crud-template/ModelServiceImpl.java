package br.uff.ihs.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.service.BaseCrudService;
import br.uff.ihs.ss.service.$Model$Service;
import br.uff.ihs.ss.repository.$Model$Repository;

@Service
public class $Model$ServiceImpl extends BaseCrudService<$Model$> implements $Model$Service {

    private $Model$Repository repository;

    @Autowired
    public $Model$ServiceImpl($Model$Repository repository) {
        this.repository = repository;
        super.setRepository(repository);
        super.setModelClass($Model$.class);
    }

    @Override
    protected void updateCrudAttributes($Model$ to, $Model$ from) {
        throw new RuntimeException("Set attributes to update");
    }

}