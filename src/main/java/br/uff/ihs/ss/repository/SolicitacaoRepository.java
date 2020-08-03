package br.uff.ihs.ss.repository;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Solicitacao;

public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {
}