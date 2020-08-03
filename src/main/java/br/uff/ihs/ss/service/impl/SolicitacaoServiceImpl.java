package br.uff.ihs.ss.service.impl;

import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.service.CrudService;

@Service
public class SolicitacaoServiceImpl extends CrudService<Solicitacao> {

    @Override
    protected Class<?> getModelClass() {
        return Solicitacao.class;
    }

    @Override
    protected void updateAttributes(Solicitacao toUpdate, Solicitacao updated) {
        // toUpdate.setAtivo(updated.getAtivo());
        // toUpdate.setCodigo(updated.getCodigo());
        // toUpdate.setEmail(updated.getEmail());
        // toUpdate.setLotacao(updated.getLotacao());
        // toUpdate.setNome(updated.getNome());
    }

}