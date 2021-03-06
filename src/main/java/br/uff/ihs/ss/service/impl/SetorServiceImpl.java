package br.uff.ihs.ss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.BaseCrudService;
import br.uff.ihs.ss.service.SetorService;
import br.uff.ihs.ss.repository.SetorRepository;

@Service
public class SetorServiceImpl extends BaseCrudService<Setor> implements SetorService {

    private SetorRepository repository;

    @Autowired
    public SetorServiceImpl(SetorRepository repository) {
        this.repository = repository;
        super.setRepository(repository);
        super.setModelClass(Setor.class);
    }

    @Override
    protected void updateCrudAttributes(Setor to, Setor from) {
        to.setNome(from.getNome());
        to.setAtivo(from.getAtivo());
        to.setEmail(from.getEmail());
    }

    @Override
    public List<Setor> findSetorAtivo() {
        return repository.findByAtivo(true);
    }

}