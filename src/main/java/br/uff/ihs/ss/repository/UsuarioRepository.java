package br.uff.ihs.ss.repository;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}