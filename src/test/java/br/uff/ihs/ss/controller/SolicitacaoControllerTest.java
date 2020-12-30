package br.uff.ihs.ss.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.uff.ihs.ss.dto.SolicitacaoDto;
import br.uff.ihs.ss.helper.SolicitacaoTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.service.SolicitacaoService;

public class SolicitacaoControllerTest extends CrudControllerTest<Solicitacao, SolicitacaoDto> {

    @InjectMocks
    SolicitacaoController solicitacaoController;

    @Mock
    private SolicitacaoService service;

    @Override
    protected CrudService<Solicitacao> getService() {
        return service;
    }

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