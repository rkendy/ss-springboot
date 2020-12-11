package br.uff.ihs.ss.service;

import java.util.List;

import br.uff.ihs.ss.model.Setor;

public interface SetorService extends CrudService<Setor> {
    public List<Setor> findSetorAtivo();
}