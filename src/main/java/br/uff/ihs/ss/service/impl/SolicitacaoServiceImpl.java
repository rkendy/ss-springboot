package br.uff.ihs.ss.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.dto.SolicitacaoFilterDto;
import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.model.Status;
import br.uff.ihs.ss.model.StatusCodigo;
import br.uff.ihs.ss.repository.SolicitacaoRepository;
import br.uff.ihs.ss.repository.SolicitacaoSpecification;
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
        Optional<Status> statusOp = statusRepository.findByCodigo(StatusCodigo.ABERTO);

        solicitacao.setCriacao(LocalDateTime.now());
        solicitacao.setStatus(statusOp.get());
        return repository.save(solicitacao);
    }

    @Override
    protected void updateCrudAttributes(Solicitacao to, Solicitacao from) {
        to.setStatus(from.getStatus());
        to.setSetor(from.getSetor());
    }

    @Override
    public Page<Solicitacao> findByFilter(SolicitacaoFilterDto filter, Pageable pageable) {
        Specification<Solicitacao> specs = Specification.where( //
                SolicitacaoSpecification.equalSetor(filter.getSetorId())) //
                .and(SolicitacaoSpecification.equalStatus(filter.getStatusId()))
                .and(SolicitacaoSpecification.equalCriador(filter.getCriadorId()))
                .and(SolicitacaoSpecification.equalResponsavel(filter.getResponsavelId()))
                .and(SolicitacaoSpecification.likeTitulo(filter.getTitulo()))
                .and(SolicitacaoSpecification.likeDescricao(filter.getDescricao()));

        return repository.findAll(specs, pageable);
    }

}