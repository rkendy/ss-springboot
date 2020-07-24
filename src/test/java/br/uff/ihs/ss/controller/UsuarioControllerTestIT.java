package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.impl.UsuarioServiceImpl;
import br.uff.ihs.ss.util.MapperUtil;

public class UsuarioControllerTestIT extends CrudControllerTestIT<Usuario> {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Override
    public String getEndPoint() {
        return UsuarioController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Usuario usuario, String json) {
        UsuarioDto expected = MapperUtil.convertToDto(usuario, UsuarioDto.class);
        UsuarioDto returned = MapperUtil.convertFromJson(json, UsuarioDto.class);
        assertNotNull(returned.getId());
        assertEquals(expected.getLogin(), returned.getLogin());
        assertEquals(expected.getNome(), returned.getNome());
        assertEquals(expected.getEmail(), returned.getEmail());
        assertTrue(returned.getAtivo());
    }

}