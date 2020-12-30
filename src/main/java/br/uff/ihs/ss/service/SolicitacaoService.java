package br.uff.ihs.ss.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.uff.ihs.ss.dto.SolicitacaoFilterDto;
import br.uff.ihs.ss.model.Solicitacao;

public interface SolicitacaoService extends CrudService<Solicitacao> {
    public Page<Solicitacao> findByFilter(SolicitacaoFilterDto filter, Pageable pageable);
}