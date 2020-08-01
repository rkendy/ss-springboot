package br.uff.ihs.ss.repository;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
}