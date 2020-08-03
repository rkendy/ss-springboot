package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.util.MapperUtil;

public class UsuarioControllerTestIT extends CrudControllerTestIT<Usuario> {

    @Override
    public String getEndPoint() {
        return UsuarioController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Usuario model, String json) {
        UsuarioDto expected = MapperUtil.convertToDto(model, UsuarioDto.class);
        UsuarioDto returned = MapperUtil.convertFromJson(json, UsuarioDto.class);
        assertNotNull(returned.getId());
        // assertEquals(expected.getCodigo(), returned.getCodigo());
        // assertEquals(expected.getNome(), returned.getNome());
        // assertEquals(expected.getEmail(), returned.getEmail());
        // assertEquals("01", returned.getLotacao());
        // assertTrue(returned.getAtivo());
    }

}