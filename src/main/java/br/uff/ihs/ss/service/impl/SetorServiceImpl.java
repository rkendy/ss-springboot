package br.uff.ihs.ss.service.impl;

import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Setor;

@Service
public class SetorServiceImpl extends CrudServiceImpl<Setor> {

    @Override
    protected Class<?> getModelClass() {
        return Setor.class;
    }

    @Override
    protected void updateAttributes(Setor toUpdate, Setor updated) {
        toUpdate.setAtivo(updated.getAtivo());
        toUpdate.setCodigo(updated.getCodigo());
        toUpdate.setEmail(updated.getEmail());
        toUpdate.setLotacao(updated.getLotacao());
        toUpdate.setNome(updated.getNome());
    }

}