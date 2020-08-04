package br.uff.ihs.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.service.BaseCrudService;
import br.uff.ihs.ss.service.SolicitacaoService;
import br.uff.ihs.ss.repository.SolicitacaoRepository;

@Service
public class SolicitacaoServiceImpl extends BaseCrudService<Solicitacao> implements SolicitacaoService {

    private SolicitacaoRepository repository;

    @Autowired
    public SolicitacaoServiceImpl(SolicitacaoRepository repository) {
        this.repository = repository;
        super.setRepository(repository);
        super.setModelClass(Solicitacao.class);
    }

}