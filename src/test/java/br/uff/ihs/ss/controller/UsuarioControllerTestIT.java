package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.impl.UsuarioServiceImpl;
import br.uff.ihs.ss.util.MapperUtil;

public class UsuarioControllerTestIT extends CrudControllerTestIT {
    @LocalServerPort
    int port;

    @Autowired
    UsuarioServiceImpl usuarioService;

    List<Usuario> list;
    Usuario usuario;
    Usuario usuarioToDelete;
    Usuario usuarioToCreate;

    @BeforeEach
    void setup() {
        list = usuarioService.findAll();
        usuario = list.get(0);
        usuarioToCreate = Usuario.builder().login("login").nome("nome").email("email@email.com").build();
    }

    @Override
    public String getEndPoint() {
        return UsuarioController.ENDPOINT;
    }

    @Override
    public Long getId() {
        return usuario.getId();
    }

    @Override
    public String getJsonToCreate() {
        return MapperUtil.convertToJson(usuarioToCreate);
    }

    @Override
    public String getJsonFromDto() {
        return MapperUtil.convertToJson(usuario.toDto());
    }

    @Override
    public void checkCreatedJson(String json) {
        UsuarioDto expected = usuarioToCreate.toDto();
        UsuarioDto returned = MapperUtil.convertFromJson(json, UsuarioDto.class);
        assertNotNull(returned.getId());
        assertEquals(expected.getLogin(), returned.getLogin());
        assertEquals(expected.getNome(), returned.getNome());
        assertEquals(expected.getEmail(), returned.getEmail());
        assertTrue(returned.getAtivo());
    }

    @Override
    public void createModel() {
        usuarioToDelete = usuarioService
                .create(Usuario.builder().login("loginx").nome("nomex").email("email@email.com").build());
    }

    @Override
    public int getCount() {
        return usuarioService.findAll().size();
    }

    @Override
    public Long getIdToDelete() {
        return usuarioToDelete.getId();
    }

    @Test
    public void teste() {
        ResponseEntity<String> response = makePostRequest(getJsonFromDto());
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
    }

}