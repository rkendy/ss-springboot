package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.uff.ihs.ss.dto.SolicitacaoDto;
import br.uff.ihs.ss.model.Solicitacao;

public class SolicitacaoControllerTestIT extends CrudControllerTestIT<Solicitacao> {

    @Override
    public String getEndPoint() {
        return SolicitacaoController.ENDPOINT;
    }

    @Override
    public void checkCreatedJson(Solicitacao model, String json) {
        SolicitacaoDto expected = mapperUtil.convertToDto(model, SolicitacaoDto.class);
        SolicitacaoDto returned = mapperUtil.convertFromJson(json, SolicitacaoDto.class);
        assertNotNull(returned.getId());
        assertEquals(expected.getTitulo(), returned.getTitulo());
        assertEquals(expected.getDescricao(), returned.getDescricao());
    }

}