package br.uff.ihs.ss.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Setor;

public interface SetorRepository extends CrudRepository<Setor, Long> {
    List<Setor> findByAtivo(Boolean ativo);
}