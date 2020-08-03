package br.uff.ihs.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.service.SolicitacaoService;
import br.uff.ihs.ss.repository.SolicitacaoRepository;

@Service
public class SolicitacaoServiceImpl extends CrudService<Solicitacao> implements SolicitacaoService {

    @Autowired
    public SolicitacaoServiceImpl(SolicitacaoRepository repository) {
        this.repository = repository;
    }

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