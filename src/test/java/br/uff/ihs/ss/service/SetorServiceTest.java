package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.helper.SetorTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.impl.SetorServiceImpl;

public class SetorServiceTest extends CrudServiceTest<Setor> {

    @InjectMocks
    private SetorServiceImpl setorService;

    private TestHelper<Setor> helper = new SetorTestHelper();

    @Override
    protected CrudService<Setor> getServiceImpl() {
        return setorService;
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