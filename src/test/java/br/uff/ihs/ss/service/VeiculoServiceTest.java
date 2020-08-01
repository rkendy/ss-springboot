package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.helper.VeiculoTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Veiculo;
import br.uff.ihs.ss.service.impl.VeiculoServiceImpl;

public class VeiculoServiceTest extends CrudServiceTest<Veiculo> {

    @InjectMocks
    private VeiculoServiceImpl VeiculoService;

    private TestHelper<Veiculo> helper = new VeiculoTestHelper();

    @Override
    protected CrudService<Veiculo> getServiceImpl() {
        return VeiculoService;
    }

    @Override
    protected TestHelper<Veiculo> getTestHelperImpl() {
        return helper;
    }

    @Override
    protected void assertAttributes(Veiculo expected, Veiculo actual) {
        // assertEquals(expected.getCodigo(), actual.getCodigo());
        // assertEquals(expected.getNome(), actual.getNome());
    }

}