package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.model.Usuario;

public class UsuarioRepositoryTest extends RepositoryTest<UsuarioRepository, Usuario> {

    @Test
    public void givenNovoUsuario_whenInsert_thenSuccess() {
        final Usuario s = Usuario.builder() //
                .login("login") //
                .nome("Nome Usuario") //
                .ativo(true) //
                .email("email@email.com") //
                .lotacao("01") //
                .build();

        final Usuario novo = repository.save(s);

        assertNotNull(novo);
        assertNotNull(novo.getId());
        assertEquals("login", novo.getLogin());
        assertEquals("Nome Usuario", novo.getNome());
        assertEquals(true, novo.getAtivo());
        assertEquals("email@email.com", novo.getEmail());
        assertEquals("01", novo.getLotacao());
    }

}