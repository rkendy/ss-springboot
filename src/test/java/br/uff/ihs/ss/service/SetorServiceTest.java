package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.helper.SetorTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.repository.SetorRepository;
import br.uff.ihs.ss.service.impl.SetorServiceImpl;

public class SetorServiceTest extends CrudServiceTest<Setor> {

    @InjectMocks
    private SetorServiceImpl setorService;

    @Mock
    private SetorRepository repository;

    private TestHelper<Setor> helper = new SetorTestHelper();

    @Override
    protected CrudService<Setor> getServiceImpl() {
        return setorService;
    }

    @Override
    protected CrudRepository<Setor, Long> getRepository() {
        return repository;
    }

    @Override
    protected TestHelper<Setor> getTestHelperImpl() {
        return helper;
    }

    @Override
    protected void assertAttributes(Setor expected, Setor actual) {
        assertEquals(expected.getCodigo(), actual.getCodigo());
        assertEquals(expected.getNome(), actual.getNome());
    }

}