package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.helper.UsuarioTestHelper;
import br.uff.ihs.ss.model.Usuario;

public class UsuarioRepositoryTest extends CrudRepositoryTest<UsuarioRepository, Usuario> {

    private UsuarioTestHelper helper = new UsuarioTestHelper();

    @Test
    public void givenNewUsuario_whenInsert_thenSuccess() {
        final Usuario e = helper.createOne();

        final Usuario created = repository.save(e);

        assertNotNull(created);
        assertNotNull(created.getId());
        // include other asserts:
        // assertEquals(e.get(), created.get());
    }

    @Test
    public void givenLogin_whenFindByLogin_thenSuccess() {
        final Usuario u = repository.findAll().iterator().next();

        final Usuario actual = repository.findByLogin(u.getLogin()).get();

        assertNotNull(actual);
        assertEquals(u.getLogin(), actual.getLogin());
        assertEquals(u.getNome(), actual.getNome());
        assertEquals(u.getEmail(), actual.getEmail());
        assertEquals(u.getAdmin(), actual.getAdmin());
    }

}