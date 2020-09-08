package br.uff.ihs.ss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);

    @Query("select u from Usuario u left join fetch u.setores where u.login = ?1")
    Optional<Usuario> findByLoginSetores(String login);
}