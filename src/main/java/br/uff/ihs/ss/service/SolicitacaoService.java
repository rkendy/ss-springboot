package br.uff.ihs.ss.service;

import java.util.List;

import br.uff.ihs.ss.dto.SolicitacaoFilterDto;
import br.uff.ihs.ss.model.Solicitacao;

public interface SolicitacaoService extends CrudService<Solicitacao> {
    List<Solicitacao> findByFilter(SolicitacaoFilterDto filter);
}