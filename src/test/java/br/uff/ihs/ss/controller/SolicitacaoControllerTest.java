package br.uff.ihs.ss.controller;

import java.util.List;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.dto.SolicitacaoDto;
import br.uff.ihs.ss.helper.SolicitacaoTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Solicitacao;

public class SolicitacaoControllerTest extends CrudControllerTest<Solicitacao, SolicitacaoDto> {

    @InjectMocks
    SolicitacaoController solicitacaoController;

    private TestHelper<Solicitacao> helper = new SolicitacaoTestHelper();

    @Override
    public String getEndPoint() {
        return SolicitacaoController.ENDPOINT;
    }

    @Override
    public BaseCrudController<Solicitacao, SolicitacaoDto> getController() {
        return solicitacaoController;
    }

    @Override
    public TestHelper<Solicitacao> getTestHelperImpl() {
        return helper;
    }

}