package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.uff.ihs.ss.dto.SolicitacaoDto;
import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.util.MapperUtil;

public class SolicitacaoControllerTestIT extends CrudControllerTestIT<Solicitacao> {

    @Override
    public String getEndPoint() {
        return SolicitacaoController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Solicitacao model, String json) {
        SolicitacaoDto expected = MapperUtil.convertToDto(model, SolicitacaoDto.class);
        SolicitacaoDto returned = MapperUtil.convertFromJson(json, SolicitacaoDto.class);
        assertNotNull(returned.getId());
        // assertEquals(expected.getCodigo(), returned.getCodigo());
        // assertEquals(expected.getNome(), returned.getNome());
        // assertEquals(expected.getEmail(), returned.getEmail());
        // assertEquals("01", returned.getLotacao());
        // assertTrue(returned.getAtivo());
    }

}