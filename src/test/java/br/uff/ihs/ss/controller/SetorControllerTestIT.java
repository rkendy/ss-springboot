package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.context.annotation.Profile;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.util.MapperUtil;

public class SetorControllerTestIT extends CrudControllerTestIT<Setor> {

    @Override
    public String getEndPoint() {
        return SetorController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Setor model, String json) {
        SetorDto expected = MapperUtil.convertToDto(model, SetorDto.class);
        SetorDto returned = MapperUtil.convertFromJson(json, SetorDto.class);
        assertNotNull(returned.getId());
        // assertEquals(expected.getCodigo(), returned.getCodigo());
        // assertEquals(expected.getNome(), returned.getNome());
        // assertEquals(expected.getEmail(), returned.getEmail());
        // assertEquals("01", returned.getLotacao());
        // assertTrue(returned.getAtivo());
    }

}