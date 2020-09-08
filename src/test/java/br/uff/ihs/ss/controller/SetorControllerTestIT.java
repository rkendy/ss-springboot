package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;

public class SetorControllerTestIT extends CrudControllerTestIT<Setor> {

    @Override
    public String getEndPoint() {
        return SetorController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Setor model, String json) {
        SetorDto expected = mapperUtil.convertToDto(model, SetorDto.class);
        SetorDto returned = mapperUtil.convertFromJson(json, SetorDto.class);
        assertNotNull(returned.getId());
        // assertEquals(expected.getCodigo(), returned.getCodigo());
        // assertEquals(expected.getNome(), returned.getNome());
        // assertEquals(expected.getEmail(), returned.getEmail());
        // assertEquals("01", returned.getLotacao());
        // assertTrue(returned.getAtivo());
    }

}