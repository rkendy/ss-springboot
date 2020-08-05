package br.uff.ihs.ss.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {
    Optional<Status> findByCodigo(Status.Codigo codigo);

}