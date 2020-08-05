package br.uff.ihs.ss.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.model.Status;
import br.uff.ihs.ss.repository.SolicitacaoRepository;
import br.uff.ihs.ss.repository.StatusRepository;
import br.uff.ihs.ss.service.BaseCrudService;
import br.uff.ihs.ss.service.SolicitacaoService;

@Service
public class SolicitacaoServiceImpl extends BaseCrudService<Solicitacao> implements SolicitacaoService {

    private SolicitacaoRepository repository;

    private StatusRepository statusRepository;

    @Autowired
    public SolicitacaoServiceImpl(SolicitacaoRepository repository, StatusRepository statusRepository) {
        this.repository = repository;
        super.setRepository(repository);
        super.setModelClass(Solicitacao.class);

        this.statusRepository = statusRepository;
    }

    @Override
    public Solicitacao create(Solicitacao solicitacao) {
        Optional<Status> statusOp = statusRepository.findByCodigo(Status.Codigo.ABERTO);

        solicitacao.setCriacao(LocalDateTime.now());
        solicitacao.setStatus(statusOp.get());
        return repository.save(solicitacao);
    }

    @Override
    protected void updateAttributes(Solicitacao to, Solicitacao from) {
        // TODO Auto-generated method stub

    }

}