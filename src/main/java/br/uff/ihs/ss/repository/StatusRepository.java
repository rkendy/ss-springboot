package br.uff.ihs.ss.repository;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {
}