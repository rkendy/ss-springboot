package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;

public class UsuarioControllerTestIT extends CrudControllerTestIT<Usuario> {

    @Override
    public String getEndPoint() {
        return UsuarioController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Usuario model, String json) {
        UsuarioDto expected = mapperUtil.convertToDto(model, UsuarioDto.class);
        UsuarioDto returned = mapperUtil.convertFromJson(json, UsuarioDto.class);
        assertNotNull(returned.getId());
        // assertEquals(expected.getCodigo(), returned.getCodigo());
        // assertEquals(expected.getNome(), returned.getNome());
        // assertEquals(expected.getEmail(), returned.getEmail());
        // assertEquals("01", returned.getLotacao());
        // assertTrue(returned.getAtivo());
    }

    @Test
    public void givenExistingLogin_whenCreate_thenReturnConflict() {

        Usuario usuario = repository.findAll().iterator().next();
        Usuario novoUsuario = helper.createOne();
        novoUsuario.setLogin(usuario.getLogin());

        ResponseEntity<String> response = makePostRequest(mapperUtil.convertToJson(novoUsuario));

        assertEquals(HttpStatus.CONFLICT.value(), response.getStatusCode().value());
    }

}