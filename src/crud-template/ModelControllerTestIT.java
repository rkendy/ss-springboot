package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.uff.ihs.ss.dto.$Model$Dto;
import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.util.MapperUtil;

public class $Model$ControllerTestIT extends CrudControllerTestIT<$Model$> {

    @Override
    public String getEndPoint() {
        return $Model$Controller.ENDPOINT;
    }

    @Override
    public void checkCreatedJson($Model$ model, String json) {
        $Model$Dto expected = MapperUtil.convertToDto(model, $Model$Dto.class);
        $Model$Dto returned = MapperUtil.convertFromJson(json, $Model$Dto.class);
        assertNotNull(returned.getId());
        // assertEquals(expected.getCodigo(), returned.getCodigo());
        // assertEquals(expected.getNome(), returned.getNome());
        // assertEquals(expected.getEmail(), returned.getEmail());
        // assertEquals("01", returned.getLotacao());
        // assertTrue(returned.getAtivo());
    }

}