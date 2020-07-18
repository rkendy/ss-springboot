package br.uff.ihs.ss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.exception.NotFoundException;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.repository.SetorRepository;
import br.uff.ihs.ss.service.SetorService;

@Service
public class SetorServiceImpl implements SetorService {

    @Autowired
    SetorRepository setorRepository;

    public List<Setor> getAll() {
        List<Setor> result = new ArrayList<>();
        setorRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Setor> getByFilter(Setor filter) {
        return null;
    }

    @Override
    public Setor getById(Long id) {
        return setorRepository.findById(id).orElseThrow(() -> new NotFoundException(Setor.class, id));
    }

}