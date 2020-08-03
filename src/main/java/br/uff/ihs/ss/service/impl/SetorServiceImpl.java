package br.uff.ihs.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.service.SetorService;
import br.uff.ihs.ss.repository.SetorRepository;

@Service
public class SetorServiceImpl extends CrudService<Setor> implements SetorService {

    @Autowired
    public SetorServiceImpl(SetorRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Class<?> getModelClass() {
        return Setor.class;
    }

    @Override
    protected void updateAttributes(Setor toUpdate, Setor updated) {
        // toUpdate.setAtivo(updated.getAtivo());
        // toUpdate.setCodigo(updated.getCodigo());
        // toUpdate.setEmail(updated.getEmail());
        // toUpdate.setLotacao(updated.getLotacao());
        // toUpdate.setNome(updated.getNome());
    }

}