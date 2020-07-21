package br.uff.ihs.ss.service;

import java.util.List;

import br.uff.ihs.ss.model.Setor;

public interface SetorService {
    List<Setor> getAll();

    Setor getById(Long id);

    List<Setor> getByFilter(Setor filter);

    Setor create(Setor setor);

    Setor update(Long id, Setor setor);
}