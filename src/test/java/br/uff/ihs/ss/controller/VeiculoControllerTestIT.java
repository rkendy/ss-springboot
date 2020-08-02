package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.uff.ihs.ss.dto.VeiculoDto;
import br.uff.ihs.ss.model.Veiculo;
import br.uff.ihs.ss.util.MapperUtil;

public class VeiculoControllerTestIT extends CrudControllerTestIT<Veiculo> {

    @Override
    public String getEndPoint() {
        return VeiculoController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Veiculo model, String json) {
        VeiculoDto expected = MapperUtil.convertToDto(model, VeiculoDto.class);
        VeiculoDto returned = MapperUtil.convertFromJson(json, VeiculoDto.class);
        assertNotNull(returned.getId());
        assertEquals(expected.getPlaca(), returned.getPlaca());
        assertEquals(expected.getModelo(), returned.getModelo());
        assertEquals(expected.getCapacidade(), returned.getCapacidade());
        assertEquals("01", returned.getLotacao());
        assertTrue(returned.getAtivo());
    }

}