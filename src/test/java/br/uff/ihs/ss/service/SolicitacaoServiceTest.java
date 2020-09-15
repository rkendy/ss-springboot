package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.helper.SolicitacaoTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.model.Status;
import br.uff.ihs.ss.model.StatusCodigo;
import br.uff.ihs.ss.repository.SolicitacaoRepository;
import br.uff.ihs.ss.repository.StatusRepository;
import br.uff.ihs.ss.service.impl.SolicitacaoServiceImpl;

public class SolicitacaoServiceTest extends CrudServiceTest<Solicitacao> {

    @InjectMocks
    private SolicitacaoServiceImpl solicitacaoService;

    @Mock
    private SolicitacaoRepository repository;

    @Mock
    private StatusRepository statusRepository;

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
        assertEquals(expected.getTitulo(), actual.getTitulo());
        assertEquals(expected.getDescricao(), actual.getDescricao());
    }

    @Override
    @Test
    public void givenModel_whenCreate_thenCreateSuccess() {

        Solicitacao expected = helper.createOne();
        StatusCodigo aberto = StatusCodigo.ABERTO;

        when(repository.save(any())).thenReturn(expected);
        // Optional<Status> statusOp =
        // statusRepository.findByCodigo(Status.Codigo.ABERTO);
        when(statusRepository.findByCodigo(aberto)) //
                .thenReturn(Optional.of(Status.builder().codigo(aberto).build()));

        Solicitacao actual = solicitacaoService.create(expected);

        assertNotNull(actual);
        assertAttributes(expected, actual);
    }

}