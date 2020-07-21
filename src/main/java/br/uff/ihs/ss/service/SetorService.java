package br.uff.ihs.ss.service;

import java.util.List;

import br.uff.ihs.ss.model.Setor;

public interface SetorService {
    List<Setor> findAll();

    Setor findById(Long id);

    List<Setor> findByFilter(Setor filter);

    Setor create(Setor setor);

    Setor update(Long id, Setor setor);

    void delete(Long id);
}