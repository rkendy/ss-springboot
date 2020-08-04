package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.helper.SolicitacaoTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.repository.SolicitacaoRepository;
import br.uff.ihs.ss.service.impl.SolicitacaoServiceImpl;

public class SolicitacaoServiceTest extends CrudServiceTest<Solicitacao> {

    @InjectMocks
    private SolicitacaoServiceImpl solicitacaoService;

    @Mock
    private SolicitacaoRepository repository;

    private TestHelper<Solicitacao> helper = new SolicitacaoTestHelper();

    @Override
    protected CrudService<Solicitacao> getServiceImpl() {
        return solicitacaoService;
    }

    @Override
    protected CrudRepository<Solicitacao, Long> getRepository() {
        return repository;
    }

    @Override
    protected TestHelper<Solicitacao> getTestHelperImpl() {
        return helper;
    }

    @Override
    protected void assertAttributes(Solicitacao expected, Solicitacao actual) {
        // assertEquals(expected.getCodigo(), actual.getCodigo());
        // assertEquals(expected.getNome(), actual.getNome());
    }

}