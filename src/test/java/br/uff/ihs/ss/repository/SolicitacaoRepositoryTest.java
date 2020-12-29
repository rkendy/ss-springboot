package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

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

    @Test
    public void givenTitulo_whenFindByTitulo_returnCorrectCount() {
        List<Solicitacao> list = repository.findAll(SolicitacaoSpecification.likeTitulo("Titulo"));
        int size = list.size();
        assertEquals(3, size);
    }

    @Test
    public void givenDescricao_whenFindByDescricao_returnCorrectCount() {
        List<Solicitacao> list = repository.findAll(SolicitacaoSpecification.likeDescricao("Descricao"));
        int size = list.size();
        assertEquals(3, size);
    }

    @Test
    public void givenSetorId_whenFindBySetor_returnCorrectCount() {
        List<Solicitacao> list = repository.findAll(SolicitacaoSpecification.equalSetor(1));
        int size = list.size();
        assertEquals(2, size);
    }

    @Test
    public void givenCriadorId_whenFindByCriador_returnCorrectCount() {
        List<Solicitacao> list = repository.findAll(SolicitacaoSpecification.equalCriador(1));
        int size = list.size();
        assertEquals(3, size);
    }

    @Test
    public void givenCriadorIdAndSetorId_whenFindBySpecification_returnCorrectCount() {
        Specification<Solicitacao> specs = Specification.where( //
                SolicitacaoSpecification.equalSetor(1) //
                        .and(SolicitacaoSpecification.equalCriador(1)));
        List<Solicitacao> list = repository.findAll(specs);
        int size = list.size();
        assertEquals(2, size);
    }

    @Test
    public void givenResponsavelId_whenFindBySpecification_returnCorrectCount() {
        List<Solicitacao> list = repository.findAll(SolicitacaoSpecification.equalResponsavel(2));
        assertEquals(2, list.size());
    }

    @Test
    public void givenStatusId_whenFindBySpecification_returnCorrectCount() {
        List<Solicitacao> list = repository.findAll(SolicitacaoSpecification.equalStatus(1));
        assertEquals(3, list.size());
    }

    @Test
    public void givenPagination_whenFindAll_returnCorrectCount() {
        int pageNumber = 0;
        int pageSize = 2;
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<Solicitacao> list = repository.findAll(null, paging);
        assertEquals(pageSize, list.getSize());
    }

}