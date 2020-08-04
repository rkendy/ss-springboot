package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.helper.SolicitacaoTestHelper;
import br.uff.ihs.ss.model.Solicitacao;

public class SolicitacaoRepositoryTest extends CrudRepositoryTest<SolicitacaoRepository, Solicitacao> {

    private SolicitacaoTestHelper helper = new SolicitacaoTestHelper();

    @Test
    public void givenNewSolicitacao_whenInsert_thenSuccess() {
        final Solicitacao e = helper.createOne();

        final Solicitacao created = repository.save(e);

        assertNotNull(created);
        assertNotNull(created.getId());
        // include other asserts:
        // assertEquals(e.get(), created.get());
    }

}