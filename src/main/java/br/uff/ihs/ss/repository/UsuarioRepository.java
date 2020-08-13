package br.uff.ihs.ss.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}